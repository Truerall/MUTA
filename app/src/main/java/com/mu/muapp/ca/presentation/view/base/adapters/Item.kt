package com.mu.muapp.ca.presentation.view.base.adapters

import android.view.View

abstract class Item<out ViewTypeSC>(val item: ViewTypeSC) {
    abstract val layoutId: Int
    abstract fun bind(view: View, position: Int)
}