package ru.ivan.englishdictionary.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_detail.view.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.ivan.englishdictionary.EnglishDictionaryApplication
import ru.ivan.englishdictionary.R
import ru.ivan.englishdictionary.detail.presenter.DetailPresenter

class DetailFragment(private val wordId:Int): MvpAppCompatFragment(), DetailView {

    private val searchPresenter: DetailPresenter by moxyPresenter {
        EnglishDictionaryApplication.graph.getDetailPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
            view.label.text = "id: $wordId"
        return view
    }

}