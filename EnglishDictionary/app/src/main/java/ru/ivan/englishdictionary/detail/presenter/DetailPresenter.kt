package ru.ivan.englishdictionary.detail.presenter

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.ivan.englishdictionary.detail.domain.DetailInteractor
import ru.ivan.englishdictionary.detail.view.DetailView
import ru.ivan.englishdictionary.di.modules.UI

@InjectViewState
class DetailPresenter(
    @UI private val uiScheduler: Scheduler,
    private val interactor: DetailInteractor
) : MvpPresenter<DetailView>() {

    var requestDisposable: Disposable = Disposable.empty()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.onFirstShow()
    }

    fun loadData(wordId: Int) {
        requestDisposable.dispose()
        viewState.hideError()

        interactor.getDetailData(wordId)
            .observeOn(uiScheduler)
            .subscribe({ it ->
                val filteredList = it.images.filter { it.isNotEmpty() }
                if (filteredList.isNotEmpty()) {
                    viewState.showImage(filteredList)
                }
                viewState.showTitle(
                    it.text,
                    it.partOfSpeechCode.getStringName(),
                    it.textTranslation,
                    it.transcription
                )
                viewState.showDifficultLevel("Уровень сложности: ${it.difficultyLevel}")
                viewState.showDefenition("Определение ${it.definition}")
                viewState.showPrefix("Перфикс: ${it.prefix}")
            }, {
                it.printStackTrace()
                viewState.showError()
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        requestDisposable.dispose()
    }
}