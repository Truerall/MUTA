package com.mu.muapp.ca.presentation.view.main.fragments.list.adapter

sealed class TransactionsListItem {

    class BasicTransactionViewModel(val id: String, val description: String, val amount: String) :
        TransactionsListItem()

}