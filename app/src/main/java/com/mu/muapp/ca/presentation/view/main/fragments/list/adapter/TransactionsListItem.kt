package com.mu.muapp.ca.presentation.view.main.fragments.list.adapter

import org.joda.time.DateTime

sealed class TransactionsListItem {

    class BasicTransactionViewModel(val description: String, val amount: String, val date: DateTime) :
        TransactionsListItem()

}