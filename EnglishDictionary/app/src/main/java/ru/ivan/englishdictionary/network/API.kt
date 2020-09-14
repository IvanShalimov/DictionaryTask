package ru.ivan.englishdictionary.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ru.ivan.englishdictionary.models.FullInformationRequestResultItem
import ru.ivan.englishdictionary.models.SearchRequestResultItem

interface API {
    @Headers("Accept:application/json")
    @GET("meanings")
    fun meanings(@Query("ids") ids:Int):Single<List<FullInformationRequestResultItem>>

    @Headers("Accept:application/json")
    @GET("words/search")
    fun search(@Query("search") word:String): Single<List<SearchRequestResultItem>>
}