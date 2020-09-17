package ru.ivan.englishdictionary.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.ivan.englishdictionary.utils.network.NetworkUtil
import javax.inject.Singleton

@Module
class NetworkModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideNetworkUtil() = NetworkUtil(context)
}