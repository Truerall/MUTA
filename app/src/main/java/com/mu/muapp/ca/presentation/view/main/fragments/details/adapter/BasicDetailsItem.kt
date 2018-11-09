package com.mu.muapp.ca.presentation.view.main.fragments.details.adapter

import android.view.View
import com.mu.muapp.R
import com.mu.muapp.ca.presentation.view.base.adapters.Item
import kotlinx.android.synthetic.main.item_transaction_details.view.*

class BasicDetailsItem(
    private val viewModel: DetailsListItem.BasicDetailsViewModel
) :
    Item<DetailsListItem.BasicDetailsViewModel>(viewModel) {

    override fun bind(view: View, position: Int) {
        view.item_transaction_details_tv_data.text = viewModel.data
        view.item_transaction_details_tv_label.text = viewModel.label
    }

    override val layoutId: Int // TODO try to move to something more static...
        get() = R.layout.item_transaction_details
}