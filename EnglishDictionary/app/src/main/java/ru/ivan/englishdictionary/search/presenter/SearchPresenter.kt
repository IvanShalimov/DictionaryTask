package ru.ivan.englishdictionary.search.presenter

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.ivan.englishdictionary.EnglishDictionaryApplication
import ru.ivan.englishdictionary.di.modules.qualifier.UI
import ru.ivan.englishdictionary.network.NetworkConnectionException
import ru.ivan.englishdictionary.search.domain.SearchInteractor
import ru.ivan.englishdictionary.search.view.SearchView
import ru.ivan.englishdictionary.utils.TextUtil
import javax.inject.Inject

@InjectViewState
class SearchPresenter(@UI var ui: Scheduler) : MvpPresenter<SearchView>() {

    @Inject
    lateinit var interactor: SearchInteractor
    private var searchDisposable: Disposable = Disposable.empty()
    private val textUtil = TextUtil()

    init {
        EnglishDictionaryApplication.graph.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showFirstTime()
    }

    fun search(searchWord: String) {
        if(!textUtil.isValidSearchKey(searchWord)) {
            return
        }
        searchDisposable.dispose()

        viewState.hideFirstTime()
        viewState.showWaitState()
        viewState.hideError()

        searchDisposable = interactor.search(searchWord)
            .observeOn(ui)
            .subscribe ({ result ->
                if(result.isEmpty()){
                    viewState.showError()
                } else {
                    viewState.showResult(result)
                }

                viewState.hideWaitState()
            }, {
                if(it is NetworkConnectionException){
                    viewState.showError(it.msg)
                } else {
                    viewState.showError()
                }
                it.printStackTrace()
                viewState.hideWaitState()
                viewState.hideResult()

            })
    }

    override fun onDestroy() {
        super.onDestroy()
        searchDisposable.dispose()
    }

}