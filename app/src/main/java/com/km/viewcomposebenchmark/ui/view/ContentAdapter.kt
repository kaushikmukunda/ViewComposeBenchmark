package com.km.viewcomposebenchmark.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.km.viewcomposebenchmark.R
import com.km.viewcomposebenchmark.api.Items.ROW_MODELS
import com.km.viewcomposebenchmark.api.RowModel

class ContentAdapter : RecyclerView.Adapter<RowViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        return RowViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        holder.bind(ROW_MODELS[position])
    }

    override fun getItemCount(): Int {
        return ROW_MODELS.size
    }
}

class RowViewHolder(view: ViewGroup): RecyclerView.ViewHolder(
    LayoutInflater.from(view.context).inflate(R.layout.item_row, view, false)
) {

    private val img = itemView.findViewById<ImageView>(R.id.row_image)
    private val text = itemView.findViewById<TextView>(R.id.row_text)

    fun bind(model: RowModel) {
        img.setImageResource(model.imgRes)
        text.text = model.text
    }

}