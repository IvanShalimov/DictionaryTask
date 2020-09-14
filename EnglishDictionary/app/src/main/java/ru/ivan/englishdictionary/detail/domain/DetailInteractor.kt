package ru.ivan.englishdictionary.detail.domain

import io.reactivex.rxjava3.core.Single
import ru.ivan.englishdictionary.detail.presenter.DetailInfo

interface DetailInteractor {
    fun getDetailData(wordId: Int): Single<DetailInfo>
}