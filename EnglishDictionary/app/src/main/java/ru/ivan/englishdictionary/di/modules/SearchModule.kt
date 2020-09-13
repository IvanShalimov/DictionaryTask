package ru.ivan.englishdictionary.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler
import ru.ivan.englishdictionary.search.domain.SearchInteractor
import ru.ivan.englishdictionary.search.domain.SearchInteractorImpl
import ru.ivan.englishdictionary.search.presenter.SearchPresenter
import javax.inject.Singleton

@Module
class SearchModule {

    @Provides
    fun providePresenter(@UI uiScheduler: Scheduler): SearchPresenter {
        return SearchPresenter(uiScheduler)
    }

    @Provides
    @Singleton
    fun provideNoteDao(@IO ioScheduler:Scheduler) : SearchInteractor = SearchInteractorImpl(ioScheduler)

}