package com.mu.muapp.ca.presentation.view.main.fragments.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mu.muapp.R
import com.mu.muapp.ca.domain.entity.Transaction
import com.mu.muapp.ca.presentation.presenters.main.fragments.details.TransactionDetailsContract
import com.mu.muapp.ca.presentation.presenters.viewState.ViewState
import com.mu.muapp.ca.presentation.view.base.BaseMVPFragment
import com.mu.muapp.ca.presentation.view.main.MainRouter
import com.mu.muapp.ca.presentation.view.main.fragments.details.adapter.DetailsListAdapter
import com.mu.muapp.ca.presentation.view.main.fragments.details.viewModel.TransactionListDetailsViewModel
import kotlinx.android.synthetic.main.frg_transaction_details.*

/**
 * A placeholder fragment containing a simple view.
 */
class TransactionsDetailsFragment :
    BaseMVPFragment<TransactionDetailsContract.ITransactionDetailsPresenter, TransactionListDetailsViewModel, MainRouter>(),
    TransactionDetailsContract.ITransactionDetailsView {

    companion object {
        val TAG = "TransactionsDetailsFragment"

        private val KEY_TRANSACTION_ID = "transaction_id"

        fun newInstance(transactionId: String): Fragment {
            val args = Bundle()
            args.putString(KEY_TRANSACTION_ID, transactionId)
            val fragment = TransactionsDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var adapter: DetailsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = DetailsListAdapter(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frg_transaction_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.context = context
        rvTransactionDetails.layoutManager = LinearLayoutManager(context)
        rvTransactionDetails.adapter = adapter
        presenter.getTransactionDetails(arguments?.getString(KEY_TRANSACTION_ID) ?: "")
    }

    override fun displayTransactionDetails(transaction: Transaction) {
        frg_transaction_details_tv_acc_num_data.text = transaction.otherAccount
        frg_transaction_details_tv_acc_balance.text = transaction.amount
        adapter.setData(transaction)
        viewModel.viewState = ViewState.IDLE
    }
}
