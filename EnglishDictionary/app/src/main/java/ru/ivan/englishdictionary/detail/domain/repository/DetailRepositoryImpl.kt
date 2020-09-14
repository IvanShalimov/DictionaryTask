package ru.ivan.englishdictionary.detail.domain.repository

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ivan.englishdictionary.models.FullInformationRequestResultItem
import ru.ivan.englishdictionary.network.API
import ru.ivan.englishdictionary.network.NetworkConnectionException
import ru.ivan.englishdictionary.network.NetworkUtil

class DetailRepositoryImpl(private val networkUtil: NetworkUtil) : DetailRepository {

    private val api: API by lazy {initAPI() }

    override fun request(id:Int): Single<FullInformationRequestResultItem> {
        if(!networkUtil.isNetwrokConnected()) {
            return Single.error(NetworkConnectionException())
        }

        return api.meanings(id)
            .map { it.first() }
    }

    private fun initAPI(): API {
        val host = "https://dictionary.skyeng.ru/api/public/v1/"
        val retrofit = Retrofit.Builder()
            .baseUrl(host)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        return retrofit.create(API::class.java)
    }
}