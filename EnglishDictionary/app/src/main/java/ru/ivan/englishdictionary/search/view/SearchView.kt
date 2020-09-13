package ru.ivan.englishdictionary.search.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.ivan.englishdictionary.search.presenter.models.SearchItem

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface SearchView: MvpView {
    fun showResult(result: List<SearchItem>)
    fun hideResult()
    fun showError(text:String = "Не удалось найти ничего по заданному слову")
    fun hideError()
    fun showFirstTime()
    fun hideFirstTime()
    fun showWaitState()
    fun hideWaitState()
}