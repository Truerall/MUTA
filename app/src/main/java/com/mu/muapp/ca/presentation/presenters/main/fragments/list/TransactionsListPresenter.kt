package com.mu.muapp.ca.presentation.presenters.main.fragments.list

import com.mu.muapp.ca.presentation.presenters.BaseMVPPresenter
import javax.inject.Inject

class TransactionsListPresenter @Inject constructor() :
    BaseMVPPresenter<TransactionsListContract.ITransactionsListView>(),
    TransactionsListContract.ITransactionsListPresenter{

    override fun getTransactions() {
        println("yep - presenter injected")
        view?.displayTransactions()
    }
}