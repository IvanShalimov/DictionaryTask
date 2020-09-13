package ru.ivan.englishdictionary.search.domain.repository

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ivan.englishdictionary.models.Meaning
import ru.ivan.englishdictionary.network.API

class SearchRepositoryImpl : SearchRepository {

    private val api: API by lazy {initAPI() }

    override fun request(word: String): Single<List<Meaning>> {
        return api.search(word)
            .map { it.first().meanings }//Все обёрнуто в массив, поэтому беру первый элемент
    }

    private fun initAPI(): API {
        val host: String = "https://dictionary.skyeng.ru/api/public/v1/"
        val retrofit = Retrofit.Builder()
            .baseUrl(host)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        return retrofit.create(API::class.java)
    }

}