package com.mu.muapp.ca.presentation.view.main.fragments.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mu.muapp.R
import com.mu.muapp.ca.presentation.presenters.main.fragments.details.TransactionDetailsContract
import com.mu.muapp.ca.presentation.view.base.BaseMVPFragment
import com.mu.muapp.ca.presentation.view.main.MainRouter
import com.mu.muapp.ca.presentation.view.main.fragments.details.viewModel.TransactionListDetailsViewModel
import kotlinx.android.synthetic.main.frg_transaction_details.*

/**
 * A placeholder fragment containing a simple view.
 */
class TransactionsDetailsFragment :
    BaseMVPFragment<TransactionDetailsContract.ITransactionDetailsPresenter, TransactionListDetailsViewModel, MainRouter>() {

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frg_transaction_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        frg_transaction_details_tv_acc_num_data.text = arguments?.getString(KEY_TRANSACTION_ID)
    }
}
