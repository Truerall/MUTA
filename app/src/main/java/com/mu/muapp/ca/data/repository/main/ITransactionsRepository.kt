package com.mu.muapp.ca.data.repository.main

import com.mu.muapp.ca.data.source.api.response.TransactionsResponse
import com.mu.muapp.ca.domain.entity.Transaction
import io.reactivex.Single

interface ITransactionsRepository {
    fun getTransactions(): Single<TransactionsResponse>

    fun getTransaction(transactionId: String): Single<Transaction>
}