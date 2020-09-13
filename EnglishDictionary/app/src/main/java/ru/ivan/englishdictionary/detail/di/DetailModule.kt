package ru.ivan.englishdictionary.detail.di

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler
import ru.ivan.englishdictionary.detail.presenter.DetailPresenter
import ru.ivan.englishdictionary.di.modules.qualifier.UI

@Module
class DetailModule {

    @Provides
    fun provideDetailPresenter(@UI uiScheduler:Scheduler) = DetailPresenter(uiScheduler)
}