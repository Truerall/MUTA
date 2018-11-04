package com.mu.muapp.ca.data.repository.main

import com.mu.muapp.ca.domain.entity.Transaction
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * NO API provided for test assignment, so this repo is just a dummy to show approach with switching of repos
 * according to build type.
 */
class TransactionsRepository @Inject constructor() : ITransactionsRepository {

    private val transactionsList: List<Transaction> = emptyList()

    override fun getTransactions(): Single<List<Transaction>> {
        return Single.just(transactionsList).delay(5, TimeUnit.SECONDS)
    }

}