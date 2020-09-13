package ru.ivan.englishdictionary.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.jakewharton.rxbinding4.widget.textChanges
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import kotlinx.android.synthetic.main.fragment_search.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.ivan.englishdictionary.EnglishDictionaryApplication
import ru.ivan.englishdictionary.R
import ru.ivan.englishdictionary.di.modules.IO
import ru.ivan.englishdictionary.di.modules.UI
import ru.ivan.englishdictionary.search.presenter.SearchPresenter
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchFragment : MvpAppCompatFragment(), SearchView {

    private val searchPresenter: SearchPresenter by moxyPresenter {
        EnglishDictionaryApplication.graph.getSearchPresenter()
    }

    @Inject
    @UI lateinit var uiScheduler: Scheduler
    @Inject
    @IO
    lateinit var ioScheduler: Scheduler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EnglishDictionaryApplication.graph.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun showResult() {

    }

    override fun showError() {

    }

    override fun showFirstTime() {
        firstShowLabel.isVisible = true
        search.textChanges()
            .skipInitialValue()
            .filter { it.length >= 2 }
            .debounce(100, TimeUnit.MILLISECONDS)
            .subscribeOn( ioScheduler)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { searchPresenter.search(it.toString()) }
    }

    override fun hideFirstTime() {
        firstShowLabel.isVisible = false
    }

    override fun showWaitState() {
        searchPrgressBar.isVisible = true
    }

    override fun hideWaitState() {
        searchPrgressBar.isVisible = false
    }

}