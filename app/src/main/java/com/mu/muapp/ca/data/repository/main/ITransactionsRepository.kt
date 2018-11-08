package com.mu.muapp.ca.data.repository.main

import com.mu.muapp.ca.data.source.api.response.TransactionsResponse
import io.reactivex.Single

interface ITransactionsRepository {
    fun getTransactions(): Single<TransactionsResponse>
}