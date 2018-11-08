package com.mu.muapp.ca.presentation.view.main.fragments.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mu.muapp.R
import com.mu.muapp.ca.domain.entity.Transaction
import com.mu.muapp.ca.presentation.presenters.main.fragments.list.TransactionsListContract
import com.mu.muapp.ca.presentation.presenters.viewState.ViewState
import com.mu.muapp.ca.presentation.view.base.BaseMVPFragment
import com.mu.muapp.ca.presentation.view.main.fragments.list.adapter.TransactionsListAdapter
import com.mu.muapp.ca.presentation.view.main.fragments.list.viewModel.TransactionListFragmentViewModel
import kotlinx.android.synthetic.main.frg_transactions_list.*

class TransactionsListFragment :
    BaseMVPFragment<TransactionsListContract.ITransactionsListPresenter, TransactionListFragmentViewModel>(),
    TransactionsListContract.ITransactionsListView {

    private lateinit var adapter: TransactionsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TransactionsListAdapter( //the frg is retained
            listener = { item, position ->
                println("yep its clicked - " + item.description)
                println("yep its position is - " + position)
                println("yep its time is - " + item.date)
            }
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frg_transactions_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvTransactions.layoutManager = LinearLayoutManager(context)
        rvTransactions.adapter = adapter

        if (savedInstanceState == null) {
            presenter.getTransactions()
        } else {
            presenter.applyState(viewModel.viewState)
            frg_transactions_tv_acc_num_data.text = viewModel.account
            frg_transactions_tv_acc_balance.text = viewModel.balance
        }
    }

    override fun displayAccData(account: String, balance: String) {
        viewModel = TransactionListFragmentViewModel(account, balance)
        viewModel.viewState = ViewState.IDLE
        frg_transactions_tv_acc_num_data.text = account
        frg_transactions_tv_acc_balance.text = balance
    }

    override fun displayTransactions(list: List<Transaction>) {
        adapter.setData(list)
    }
}
