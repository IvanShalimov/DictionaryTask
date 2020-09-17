package ru.ivan.englishdictionary.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler
import ru.ivan.englishdictionary.di.modules.qualifier.IO
import ru.ivan.englishdictionary.di.modules.qualifier.UI
import ru.ivan.englishdictionary.search.domain.SearchInteractor
import ru.ivan.englishdictionary.search.domain.SearchInteractorImpl
import ru.ivan.englishdictionary.search.domain.repository.SearchRepository
import ru.ivan.englishdictionary.search.domain.repository.SearchRepositoryImpl
import ru.ivan.englishdictionary.search.presenter.SearchPresenter
import ru.ivan.englishdictionary.search.presenter.SearchScreenMapper
import ru.ivan.englishdictionary.utils.network.NetworkUtil
import javax.inject.Singleton

@Module
class SearchModule {

    @Provides
    fun providePresenter(@UI uiScheduler: Scheduler): SearchPresenter {
        return SearchPresenter(uiScheduler)
    }

    @Provides
    @Singleton
    fun provideSearchInteractor(@IO ioScheduler:Scheduler,
                                searchRepository: SearchRepository,
                                searchScreenMapper:  SearchScreenMapper
    ) : SearchInteractor = SearchInteractorImpl(ioScheduler, searchRepository, searchScreenMapper)

    @Provides
    @Singleton
    fun provideMapper() = SearchScreenMapper()

    @Provides
    @Singleton
    fun provideRepository(networkUtil: NetworkUtil): SearchRepository = SearchRepositoryImpl(networkUtil)

}