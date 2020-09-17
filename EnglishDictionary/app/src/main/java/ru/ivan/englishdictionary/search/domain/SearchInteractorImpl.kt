package ru.ivan.englishdictionary.search.domain

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import ru.ivan.englishdictionary.di.modules.IO
import ru.ivan.englishdictionary.search.domain.repository.SearchRepository
import ru.ivan.englishdictionary.search.presenter.SearchScreenMapper
import ru.ivan.englishdictionary.search.presenter.models.SearchItem
import java.util.concurrent.TimeUnit

class SearchInteractorImpl(
    @IO private val io: Scheduler,
    private val searchRepository: SearchRepository,
    private val searchScreenMapper: SearchScreenMapper
) : SearchInteractor {

    override fun search(searchWord: String): Single<List<SearchItem>> {
        return searchRepository.request(searchWord)
            .map { searchScreenMapper.map(it) }
            .timeout(5000, TimeUnit.MILLISECONDS)
            .subscribeOn(io)
    }


}