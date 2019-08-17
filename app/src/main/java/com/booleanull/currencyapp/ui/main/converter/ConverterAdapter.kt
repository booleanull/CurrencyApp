package com.booleanull.currencyapp.ui.main.converter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.booleanull.currencyapp.R
import kotlinx.android.synthetic.main.view_converter.view.*

class ConverterAdapter(val items: MutableList<String>) : RecyclerView.Adapter<ConverterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.view_converter, parent, false
        )
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[holder.adapterPosition])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) {
            with(itemView) {
                text_view.text = item
            }
        }
    }
}