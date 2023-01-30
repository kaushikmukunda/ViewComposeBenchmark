package com.km.viewcomposebenchmark.api

import androidx.annotation.DrawableRes

data class RowModel(
    @DrawableRes val imgRes: Int,
    val text: String
)


object Items {
    val ROW_MODELS = listOf(
        RowModel(com.google.android.material.R.drawable.material_ic_calendar_black_24dp, "Item 1"),
        RowModel(com.google.android.material.R.drawable.ic_clock_black_24dp, "Item 2"),
        RowModel(com.google.android.material.R.drawable.ic_keyboard_black_24dp, "Item 3"),
        RowModel(com.google.android.material.R.drawable.material_ic_keyboard_arrow_previous_black_24dp, "Item 4"),
        RowModel(com.google.android.material.R.drawable.ic_m3_chip_close, "Item 5"),
        RowModel(com.google.android.material.R.drawable.ic_mtrl_checked_circle, "Item 6"),
        RowModel(com.google.android.material.R.drawable.ic_mtrl_chip_checked_black, "Item 7"),
        RowModel(com.google.android.material.R.drawable.ic_mtrl_chip_checked_circle, "Item 8"),
        RowModel(com.google.android.material.R.drawable.abc_ic_arrow_drop_right_black_24dp, "Item 9"),
        RowModel(com.google.android.material.R.drawable.ic_mtrl_chip_close_circle, "Item 10"),
    )
}