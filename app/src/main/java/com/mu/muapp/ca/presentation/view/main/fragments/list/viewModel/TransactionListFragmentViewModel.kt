package com.mu.muapp.ca.presentation.view.main.fragments.list.viewModel

import com.mu.muapp.ca.presentation.presenters.main.fragments.list.ITransactionsListFrgViewModel
import com.mu.muapp.ca.presentation.view.base.viewModel.BaseViewModel
import javax.inject.Inject

class TransactionListFragmentViewModel @Inject constructor() : BaseViewModel(), ITransactionsListFrgViewModel {
    var account: String = ""
    var balance: String = ""

    constructor(account: String, balance: String) : this(){
        this.account = account
        this.balance = balance
    }
}