package com.mu.muapp.ca.presentation.presenters.main.fragments.list

import com.mu.muapp.ca.presentation.view.base.BaseContract

class TransactionsListContract {
    interface ITransactionsListView : BaseContract.BaseView {
        fun displayTransactions()
    }

    interface ITransactionsListPresenter : BaseContract.BasePresenter{
        fun getTransactions()
    }
}