package ru.ivan.englishdictionary.di

import dagger.Component
import ru.ivan.englishdictionary.detail.di.DetailModule
import ru.ivan.englishdictionary.detail.presenter.DetailPresenter
import ru.ivan.englishdictionary.di.modules.NetworkModule
import ru.ivan.englishdictionary.di.modules.SchedulersModule
import ru.ivan.englishdictionary.di.modules.SearchModule
import ru.ivan.englishdictionary.search.presenter.SearchPresenter
import ru.ivan.englishdictionary.search.view.SearchFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [SearchModule::class, NetworkModule::class,DetailModule::class, SchedulersModule::class])
interface AppComponent {
    fun inject(searchPresenter: SearchPresenter)
    fun inject(searchFragment: SearchFragment)
    fun getSearchPresenter(): SearchPresenter
    fun getDetailPresenter(): DetailPresenter
}