package ru.ivan.englishdictionary.search.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface SearchView: MvpView {
    fun showResult()
    fun showError()
    fun showFirstTime()
    fun hideFirstTime()
    fun showWaitState()
    fun hideWaitState()
}