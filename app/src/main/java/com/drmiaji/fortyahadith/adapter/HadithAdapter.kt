package com.drmiaji.fortyahadith.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drmiaji.fortyahadith.R
import com.drmiaji.fortyahadith.data.Hadith

class HadithAdapter(
    private val items: List<Hadith>,
    private val onClick: (Hadith) -> Unit
) : RecyclerView.Adapter<HadithAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.chapter_title)
        init {
            view.setOnClickListener {
                onClick(items[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleView.text = items[position].title
    }

    fun updateData(newList: List<Hadith>) {
        (items as MutableList).clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }
}