package com.mu.muapp.ca.presentation.presenters.main.fragments.details

import com.mu.muapp.ca.domain.entity.Transaction
import com.mu.muapp.ca.presentation.view.base.BaseContract

class TransactionDetailsContract {
    interface ITransactionDetailsView : BaseContract.BaseView {
        fun displayTransactionDetails(transaction: Transaction)
    }

    interface ITransactionDetailsPresenter : BaseContract.BasePresenter{
        fun getTransactionDetails(transactionId: String)
    }
}