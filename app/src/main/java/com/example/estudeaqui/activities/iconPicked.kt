package com.example.estudeaqui.activities

import com.example.estudeaqui.R

object iconPicked {
    val icons = arrayOf(
        R.drawable.chuupt,
        R.drawable.chuupt,
        R.drawable.chuupt,
        R.drawable.chuupt,
        R.drawable.chuupt,
        R.drawable.chuupt,
        R.drawable.chuupt,

        )
    var currentIcon = 0

    fun getIcon(): Int {
        currentIcon = (currentIcon + 1) % icons.size
        return icons[currentIcon]
    }
}