package com.mu.muapp.ca.data.repository.main

import com.mu.muapp.ca.domain.entity.Transaction

interface ITransactionsRepository {
    fun getTransactions(): List<Transaction>
}