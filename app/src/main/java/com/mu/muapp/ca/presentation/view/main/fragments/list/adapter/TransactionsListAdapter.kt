package com.mu.muapp.ca.presentation.view.main.fragments.list.adapter

import com.mu.muapp.ca.domain.entity.Transaction
import com.mu.muapp.ca.presentation.view.base.adapters.BaseAdapter
import com.mu.muapp.ca.presentation.view.base.adapters.Item

class TransactionsListAdapter(val listener: (TransactionsListItem.BasicTransactionViewModel, position: Int) -> Unit) :
    BaseAdapter<TransactionsListItem>() {

    fun setData(list: List<Transaction>) {
        setDataSet(toViewModelList(list))
        notifyDataSetChanged()
    }

    private fun toViewModelList(list: List<Transaction>): MutableList<Item<TransactionsListItem>> {
        val data: MutableList<Item<TransactionsListItem>> = mutableListOf()

        list.forEach {
            data.add(
                BasicTransactionItem(
                    TransactionsListItem.BasicTransactionViewModel(
                        it.description,
                        it.amount,
                        it.date
                    ),
                    listener
                )
            )
        }
        return data
    }
}