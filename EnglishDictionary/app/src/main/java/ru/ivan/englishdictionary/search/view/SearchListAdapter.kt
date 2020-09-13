package ru.ivan.englishdictionary.search.view

import android.graphics.Typeface.BOLD
import android.graphics.Typeface.ITALIC
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.search_item.view.*
import ru.ivan.englishdictionary.R
import ru.ivan.englishdictionary.search.presenter.models.SearchItem

class SearchListAdapter(val callback:(Int)->Unit):RecyclerView.Adapter<SearchListAdapter.SearchItemViewHolder>() {

    var items = listOf<SearchItem>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.search_item,parent,false)
        return SearchItemViewHolder(layout)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        holder.handle(items[position])
    }

    inner class SearchItemViewHolder(private val layout:View):RecyclerView.ViewHolder(layout){
        private val SIGNS = " [] ("

        fun handle(item: SearchItem) {
            val partOfSpeech = item.partOfSpeechCode.getStringName()
            val starItalic = item.text.length+item.transcription.length+SIGNS.length
            val endItalic = starItalic+partOfSpeech.length

            val spannable = SpannableString("${item.text} [${item.transcription}] ($partOfSpeech)")
            spannable.setSpan(StyleSpan(BOLD),0,item.text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            spannable.setSpan(StyleSpan(ITALIC),starItalic, endItalic, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            layout.translateText.text = spannable

            layout.noteText.text = item.note

            Glide
                .with(layout.context)
                .load("http:${item.previewUrl}")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(layout.previewImage)

            layout.searchItemContainer.setOnClickListener { callback(item.id) }
        }

    }
}