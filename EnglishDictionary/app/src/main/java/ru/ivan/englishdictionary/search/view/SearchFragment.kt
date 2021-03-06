package ru.ivan.englishdictionary.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding4.widget.textChanges
import io.reactivex.rxjava3.core.Scheduler
import kotlinx.android.synthetic.main.fragment_search.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.ivan.englishdictionary.EnglishDictionaryApplication
import ru.ivan.englishdictionary.R
import ru.ivan.englishdictionary.detail.view.DetailFragment
import ru.ivan.englishdictionary.detail.view.NavigateListener
import ru.ivan.englishdictionary.di.modules.IO
import ru.ivan.englishdictionary.di.modules.UI
import ru.ivan.englishdictionary.search.presenter.SearchPresenter
import ru.ivan.englishdictionary.search.presenter.models.SearchItem
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchFragment : MvpAppCompatFragment(), SearchView {

    @Inject
    @UI
    lateinit var uiScheduler: Scheduler

    @Inject
    @IO
    lateinit var ioScheduler: Scheduler

    private val adapter: SearchListAdapter by lazy {
        SearchListAdapter {
            (activity as NavigateListener).navigateTo(
                DetailFragment(it)
            )
        }
    }
    private val searchPresenter: SearchPresenter by moxyPresenter {
        EnglishDictionaryApplication.graph.getSearchPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EnglishDictionaryApplication.graph.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_search, container, false)

    override fun showResult(result: List<SearchItem>) {
        adapter.items = result
        searchResultList.isVisible = true
    }

    override fun hideResult() {
        searchResultList.isVisible = false
    }

    override fun showError(text: String) {
        searchErrorLabel.isVisible = true
    }

    override fun hideError() {
        searchErrorLabel.isVisible = false
    }

    override fun showFirstTime() {
        firstShowLabel.isVisible = true
        searchResultList.layoutManager = LinearLayoutManager(context)
        searchResultList.adapter = adapter

        search.textChanges()
            .skipInitialValue()
            .filter { it.length >= 2 }
            .debounce(100, TimeUnit.MILLISECONDS)
            .subscribeOn(ioScheduler)
            .observeOn(uiScheduler)
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