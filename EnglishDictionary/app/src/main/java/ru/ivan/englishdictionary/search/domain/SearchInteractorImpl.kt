package ru.ivan.englishdictionary.search.domain

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.ivan.englishdictionary.di.modules.IO

class SearchInteractorImpl(@IO val io:Scheduler) : SearchInteractor {

    override fun request(searchWord: String): Single<String> {
        return Single.just("Test")
            .subscribeOn(Schedulers.io())
    }
}