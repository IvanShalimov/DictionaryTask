package ru.ivan.englishdictionary.detail.domain.repository

import io.reactivex.rxjava3.core.Single
import ru.ivan.englishdictionary.models.FullInformationRequestResultItem

interface DetailRepository {
    fun request(id:Int): Single<FullInformationRequestResultItem>
}