package ru.ivan.englishdictionary.detail.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(value = AddToEndSingleStrategy::class)
interface DetailView : MvpView {
    fun onFirstShow()
    fun showError()
    fun hideError()
    fun showTitle(text:String, partOfSpeach:String, textTranslate:String, transciption:String)
    fun showImage(imageUrls:List<String>)
    fun showDifficultLevel(difficultLevel:String)
    fun showDefenition(defenition:String)
    fun showPrefix(prefix:String)
}