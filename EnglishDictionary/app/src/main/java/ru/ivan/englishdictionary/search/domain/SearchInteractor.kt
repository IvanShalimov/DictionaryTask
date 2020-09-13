package ru.ivan.englishdictionary.search.domain

import io.reactivex.rxjava3.core.Single

interface SearchInteractor {
    fun request(searchWord: String):Single<String>
}