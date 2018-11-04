package com.mu.muapp.ca.presentation.view.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mu.muapp.R
import com.mu.muapp.ca.domain.entity.Transaction
import com.mu.muapp.ca.presentation.presenters.main.fragments.list.TransactionsListContract
import com.mu.muapp.ca.presentation.view.base.BaseMVPFragment

class TransactionsListFragment :
    BaseMVPFragment<TransactionsListContract.ITransactionsListPresenter>(),
    TransactionsListContract.ITransactionsListView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frg_transactions_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getTransactions()
    }


    override fun displayTransactions(list: List<Transaction>) {
        println("yep tansactions "+ list)
    }
}
