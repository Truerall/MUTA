package com.mu.muapp.ca.presentation.view.main.fragments.details.adapter

import android.content.Context
import com.mu.muapp.R
import com.mu.muapp.ca.domain.entity.Transaction
import com.mu.muapp.ca.presentation.view.base.adapters.BaseAdapter
import com.mu.muapp.ca.presentation.view.base.adapters.Item

class DetailsListAdapter(var context: Context?) : BaseAdapter<DetailsListItem>() {
    fun setData(transaction: Transaction) {
        setDataSet(toViewModelList(transaction))
        notifyDataSetChanged()
    }

    private fun toViewModelList(transaction: Transaction): MutableList<Item<DetailsListItem>> {
        val data: MutableList<Item<DetailsListItem>> = mutableListOf()

        data.add(BasicDetailsItem(DetailsListItem.BasicDetailsViewModel(context?.getString(R.string.frg_transaction_details_tv_description_label) ?: "", transaction.description)))
        data.add(BasicDetailsItem(DetailsListItem.BasicDetailsViewModel(context?.getString(R.string.frg_transaction_details_tv_date_label) ?: "", transaction.date.toString())))
        data.add(BasicDetailsItem(DetailsListItem.BasicDetailsViewModel(context?.getString(R.string.frg_transaction_details_tv_amount_before_label) ?: "", transaction.amountBefore)))
        data.add(BasicDetailsItem(DetailsListItem.BasicDetailsViewModel(context?.getString(R.string.frg_transaction_details_tv_amount_after_label) ?: "", transaction.amountAfter)))

        return data
    }
}