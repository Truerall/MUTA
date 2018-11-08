package com.mu.muapp.ca.presentation.presenters.main.fragments.list

import com.mu.muapp.ca.domain.entity.Transaction
import com.mu.muapp.ca.presentation.view.base.BaseContract

class TransactionsListContract {
    interface ITransactionsListView : BaseContract.BaseView {
        fun displayAccData(account: String, balance: String)
        fun displayTransactions(list: List<Transaction>)
    }

    interface ITransactionsListPresenter : BaseContract.BasePresenter {
        fun getTransactions()
    }
}