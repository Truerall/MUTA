package com.mu.muapp.ca.presentation.presenters.main.fragments.details

import com.mu.muapp.ca.presentation.presenters.BaseMVPPresenter
import javax.inject.Inject

class TransactionDetailsPresenter @Inject constructor() :
    BaseMVPPresenter<TransactionDetailsContract.ITransactionDetailsView>(),
    TransactionDetailsContract.ITransactionDetailsPresenter {

    override fun detTransactionDetails() {
        view?.displayTransactionDetails()
    }
}