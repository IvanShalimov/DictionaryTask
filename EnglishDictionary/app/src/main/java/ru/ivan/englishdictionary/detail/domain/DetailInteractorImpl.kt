package ru.ivan.englishdictionary.detail.domain

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import ru.ivan.englishdictionary.detail.domain.repository.DetailRepository
import ru.ivan.englishdictionary.detail.presenter.DetailInfo
import ru.ivan.englishdictionary.detail.presenter.DetailMapper
import ru.ivan.englishdictionary.di.modules.IO

class DetailInteractorImpl(
    private val detailMapper: DetailMapper,
    private val detailRepository: DetailRepository,
    @IO private val ioScheduler: Scheduler
) : DetailInteractor {

    override fun getDetailData(wordId: Int): Single<DetailInfo> {
        return detailRepository.request(wordId)
            .map { detailMapper.map(it) }
            .subscribeOn(ioScheduler)
    }
}