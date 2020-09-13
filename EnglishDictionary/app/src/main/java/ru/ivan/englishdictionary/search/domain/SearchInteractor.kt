package ru.ivan.englishdictionary.search.domain

import io.reactivex.rxjava3.core.Single
import ru.ivan.englishdictionary.search.presenter.models.SearchItem

interface SearchInteractor {
    fun request(searchWord: String):Single<List<SearchItem>>
}