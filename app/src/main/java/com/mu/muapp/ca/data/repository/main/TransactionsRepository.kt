package com.mu.muapp.ca.data.repository.main

import android.app.Application
import com.google.gson.Gson
import com.mu.muapp.ca.domain.entity.Transaction
import com.mu.muapp.utils.rx.ISchedulerProvider
import javax.inject.Inject

/**
 * NO API provided for test assignment, so this repo is just a dummy to show approach with switching of repos
 * according to build type.
 */
class TransactionsRepository @Inject constructor(
    context: Application,
    schedulerProvider: ISchedulerProvider,
    gson: Gson
) : ITransactionsRepository {

    private val transactionsList: MutableList<Transaction> = mutableListOf()

    override fun getTransactions(): List<Transaction> {
        return transactionsList
    }
}