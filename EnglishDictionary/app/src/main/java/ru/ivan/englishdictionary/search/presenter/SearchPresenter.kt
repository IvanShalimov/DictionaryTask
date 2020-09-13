package ru.ivan.englishdictionary.search.presenter

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.ivan.englishdictionary.EnglishDictionaryApplication
import ru.ivan.englishdictionary.di.modules.qualifier.UI
import ru.ivan.englishdictionary.search.domain.SearchInteractor
import ru.ivan.englishdictionary.search.view.SearchListAdapter
import ru.ivan.englishdictionary.search.view.SearchView
import javax.inject.Inject

@InjectViewState
class SearchPresenter(@UI var ui: Scheduler) : MvpPresenter<SearchView>() {

    @Inject
    lateinit var interactor: SearchInteractor
    private var searchDisposable: Disposable = Disposable.empty()

    init {
        EnglishDictionaryApplication.graph.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showFirstTime()
    }

    fun search(searchWord: String) {
        searchDisposable.dispose()

        viewState.hideFirstTime()
        viewState.showWaitState()
        viewState.hideError()

        searchDisposable = interactor.request(searchWord)
            .observeOn(ui)
            .subscribe ({ result ->
                viewState.showResult(result)
                viewState.hideWaitState()
            }, {
                it.printStackTrace()
                viewState.hideWaitState()
                viewState.hideResult()
                viewState.showError()
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        searchDisposable.dispose()
    }

}