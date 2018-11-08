package com.mu.muapp.ca.presentation.view.main.fragments.list.adapter

import android.view.View
import com.mu.muapp.R
import com.mu.muapp.ca.presentation.view.base.adapters.Item
import kotlinx.android.synthetic.main.item_transaction.view.*

class BasicTransactionItem(
    private val viewModel: TransactionsListItem.BasicTransactionViewModel,
    private val listener: (TransactionsListItem.BasicTransactionViewModel, position: Int) -> Unit
) :
    Item<TransactionsListItem.BasicTransactionViewModel>(viewModel) {

    override fun bind(view: View, position: Int) {
        view.item_transaction_tv_amount.text = viewModel.amount
        view.item_transaction_tv_description.text = viewModel.description
        view.setOnClickListener {
            listener.invoke(viewModel, position)
        }
    }

    override val layoutId: Int // TODO try to move to something more static...
        get() = R.layout.item_transaction
}