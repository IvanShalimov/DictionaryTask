package ru.ivan.englishdictionary.detail.view

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_detail.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.ivan.englishdictionary.EnglishDictionaryApplication
import ru.ivan.englishdictionary.R
import ru.ivan.englishdictionary.detail.presenter.DetailPresenter

class DetailFragment(private val wordId: Int) : MvpAppCompatFragment(), DetailView {

    private val detailPresenter: DetailPresenter by moxyPresenter {
        EnglishDictionaryApplication.graph.getDetailComponent().getDetailPresenter()
    }

    private val adapter: ImageAdapter by lazy { ImageAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onFirstShow() {
        detailPresenter.loadData(wordId)
    }

    override fun showError() {
        errorLabel.isVisible = true
    }

    override fun hideError() {
        errorLabel.isVisible = false
    }

    override fun showTitle(
        text: String,
        partOfSpeech: String,
        textTranslate: String,
        transciption: String
    ) {
        val SIGNS = " [] ("
        val starItalic = text.length + transciption.length + SIGNS.length
        val endItalic = starItalic + partOfSpeech.length

        val spannable = SpannableString("$text [$transciption] ($partOfSpeech)")
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            StyleSpan(Typeface.ITALIC),
            starItalic,
            endItalic,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        title.isVisible = true
        title.text = spannable
    }

    override fun showImage(imageUrls: List<String>) {
        listImage.isVisible = true
        listImage.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        listImage.adapter = adapter
        adapter.items = imageUrls
    }

    override fun showDifficultLevel(difficultLevel: String) {
        difficultLevelLabel.isVisible = true
        difficultLevelLabel.text = difficultLevel
    }

    override fun showDefenition(defenition: String) {
        defenitionLabel.isVisible = true
        defenitionLabel.text = defenition
    }

    override fun showPrefix(prefix: String) {
        prefixLabel.isVisible = true
        prefixLabel.text = prefix
    }

}