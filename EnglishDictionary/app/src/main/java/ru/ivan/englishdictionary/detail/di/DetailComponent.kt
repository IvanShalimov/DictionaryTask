package ru.ivan.englishdictionary.detail.di

import dagger.Subcomponent
import ru.ivan.englishdictionary.detail.presenter.DetailPresenter

@DetailInfoScope
@Subcomponent(modules = [DetailModule::class])
interface DetailComponent {
    fun getDetailPresenter(): DetailPresenter
}