package ru.ivan.englishdictionary

import android.app.Application
import ru.ivan.englishdictionary.di.AppComponent
import ru.ivan.englishdictionary.di.DaggerAppComponent
import ru.ivan.englishdictionary.di.modules.SearchModule

class EnglishDictionaryApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        graph = DaggerAppComponent.builder().searchModule(SearchModule()).build()
    }

    companion object {
        lateinit var graph: AppComponent
    }


}