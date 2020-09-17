package ru.ivan.englishdictionary.detail.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.image_item.view.*
import ru.ivan.englishdictionary.R

class ImageAdapter:RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    var items = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(layout)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.handle(position)
    }

    inner class ImageViewHolder(private val layout: View) : RecyclerView.ViewHolder(layout) {
        fun handle(position: Int) {
            Glide
                .with(layout.context)
                .load("http:${items[position]}")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(layout.image)
        }
    }
}