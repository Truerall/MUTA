package com.mu.muapp.ca.presentation.view.base.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

open class BaseAdapter<ItemType> protected constructor() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items: MutableList<Item<ItemType>> = mutableListOf()

    fun bind(viewHolder: RecyclerView.ViewHolder, item: Item<ItemType>, position: Int) {
        item.bind(viewHolder.itemView, position)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        bind(viewHolder, getItem(position), position)
    }

    protected fun setDataSet(list: List<Item<ItemType>>){
        items.clear()
        items.addAll(list)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItem(position: Int): Item<ItemType> {
        return items[position]
    }

    fun addDataSet(list: List<Item<ItemType>>) {
        this.items.addAll(list)
    }

    fun addItem(item: Item<ItemType>) {
        this.items.add(item)
    }

    fun clearDataSet() {
        this.items.clear()
    }

    fun getView(parent: ViewGroup, layoutId: Int): View {
        return LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).layoutId
    }
}