package com.mu.muapp.ca.presentation.presenters.main.fragments.details

import com.mu.muapp.ca.presentation.view.base.BaseContract

class TransactionDetailsContract {
    interface ITransactionDetailsView : BaseContract.BaseView {
        fun displayTransactionDetails()
    }

    interface ITransactionDetailsPresenter : BaseContract.BasePresenter{
        fun detTransactionDetails()
    }
}