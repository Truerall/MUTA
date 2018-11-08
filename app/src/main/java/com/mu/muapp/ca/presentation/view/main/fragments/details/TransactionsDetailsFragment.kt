package com.mu.muapp.ca.presentation.view.main.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mu.muapp.R
import com.mu.muapp.ca.presentation.presenters.main.fragments.details.TransactionDetailsContract
import com.mu.muapp.ca.presentation.view.base.BaseMVPFragment
import com.mu.muapp.ca.presentation.view.main.fragments.details.viewModel.TransactionListDetailsViewModel

/**
 * A placeholder fragment containing a simple view.
 */
class TransactionsDetailsFragment :
    BaseMVPFragment<TransactionDetailsContract.ITransactionDetailsPresenter, TransactionListDetailsViewModel>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frg_transaction_details, container, false)
    }
}
