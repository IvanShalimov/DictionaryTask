package ru.ivan.englishdictionary.search.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.search_item.view.*
import ru.ivan.englishdictionary.R
import ru.ivan.englishdictionary.search.presenter.models.SearchItem

class SearchListAdapter:RecyclerView.Adapter<SearchListAdapter.SearchItemViewHolder>() {

    var items = listOf<SearchItem>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class SearchItemViewHolder(val layout:View):RecyclerView.ViewHolder(layout){
        fun handle(item: SearchItem) {
            layout.name.text = "${item.text} ${item.note}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.search_item,parent,false)
        return SearchItemViewHolder(layout)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        holder.handle(items[position])
    }
}