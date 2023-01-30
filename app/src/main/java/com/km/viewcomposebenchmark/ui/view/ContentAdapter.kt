package com.km.viewcomposebenchmark.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.km.viewcomposebenchmark.R
import com.km.viewcomposebenchmark.ui.view.Items.ROW_MODELS

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

data class RowModel(
    @DrawableRes val imgRes: Int,
    val text: String
)

object Items {
    val ROW_MODELS = listOf(
        RowModel(com.google.android.material.R.drawable.ic_m3_chip_checked_circle, "Item 1"),
        RowModel(com.google.android.material.R.drawable.ic_clock_black_24dp, "Item 2"),
        RowModel(com.google.android.material.R.drawable.ic_keyboard_black_24dp, "Item 3"),
        RowModel(com.google.android.material.R.drawable.ic_m3_chip_check, "Item 4"),
        RowModel(com.google.android.material.R.drawable.ic_m3_chip_close, "Item 5"),
        RowModel(com.google.android.material.R.drawable.ic_mtrl_checked_circle, "Item 6"),
        RowModel(com.google.android.material.R.drawable.ic_mtrl_chip_checked_black, "Item 7"),
        RowModel(com.google.android.material.R.drawable.ic_mtrl_chip_checked_circle, "Item 8"),
        RowModel(com.google.android.material.R.drawable.abc_ic_arrow_drop_right_black_24dp, "Item 9"),
        RowModel(com.google.android.material.R.drawable.ic_mtrl_chip_close_circle, "Item 10"),
    )
}