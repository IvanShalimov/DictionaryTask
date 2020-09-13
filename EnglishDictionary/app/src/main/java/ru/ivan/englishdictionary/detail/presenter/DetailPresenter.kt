package ru.ivan.englishdictionary.detail.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.ivan.englishdictionary.detail.view.DetailView
import ru.ivan.englishdictionary.di.modules.qualifier.UI

@InjectViewState
class DetailPresenter(@UI private val  uiScheduler: Scheduler) : MvpPresenter<DetailView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}