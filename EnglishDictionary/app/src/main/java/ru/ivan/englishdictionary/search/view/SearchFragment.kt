package ru.ivan.englishdictionary.search.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.ivan.englishdictionary.R
import ru.ivan.englishdictionary.search.presenter.SearchPresenter

class SearchFragment : MvpAppCompatFragment(), SearchView {

    /*@InjectPresenter
    lateinit var presenter: SearchPresenter*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

}