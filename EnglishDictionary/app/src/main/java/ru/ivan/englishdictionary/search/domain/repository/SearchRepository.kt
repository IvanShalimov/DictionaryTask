package ru.ivan.englishdictionary.search.domain.repository

import io.reactivex.rxjava3.core.Single
import ru.ivan.englishdictionary.models.Meaning

interface SearchRepository {
    fun request(word:String):Single<List<Meaning>>
}