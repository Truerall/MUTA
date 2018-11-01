package com.mu.muapp.ca.data.source.api.response

import com.mu.muapp.ca.domain.entity.Transaction

data class TransactionsResponse(
    val account: String,
    val balance: String,
    val transactions: List<Transaction>
)