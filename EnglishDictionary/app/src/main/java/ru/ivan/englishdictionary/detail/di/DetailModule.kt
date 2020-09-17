package ru.ivan.englishdictionary.detail.di

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler
import ru.ivan.englishdictionary.detail.domain.DetailInteractor
import ru.ivan.englishdictionary.detail.domain.DetailInteractorImpl
import ru.ivan.englishdictionary.detail.domain.repository.DetailRepository
import ru.ivan.englishdictionary.detail.domain.repository.DetailRepositoryImpl
import ru.ivan.englishdictionary.detail.presenter.DetailMapper
import ru.ivan.englishdictionary.detail.presenter.DetailPresenter
import ru.ivan.englishdictionary.di.modules.IO
import ru.ivan.englishdictionary.di.modules.UI
import ru.ivan.englishdictionary.utils.network.NetworkUtil

@Module
class DetailModule {

    @Provides
    fun provideDetailPresenter(
        @UI uiScheduler: Scheduler,
        interactor: DetailInteractor
    ) = DetailPresenter(uiScheduler, interactor)

    @Provides
    @DetailInfoScope
    fun provideInteractorDetailInfo(detailMapper: DetailMapper,
                                    detailRepository:DetailRepository,
                                    @IO ioScheduler:Scheduler): DetailInteractor {
        return DetailInteractorImpl(detailMapper, detailRepository, ioScheduler)
    }

    @Provides
    @DetailInfoScope
    fun provideDetailMapper() =  DetailMapper()

    @Provides
    @DetailInfoScope
    fun provideDetailRepository(networkUtil: NetworkUtil): DetailRepository = DetailRepositoryImpl(networkUtil)

}