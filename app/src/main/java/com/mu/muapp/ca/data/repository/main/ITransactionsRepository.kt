package com.mu.muapp.ca.data.repository.main

import com.mu.muapp.ca.domain.entity.Transaction
import io.reactivex.Single

interface ITransactionsRepository {
    fun getTransactions(): Single<List<Transaction>>
}