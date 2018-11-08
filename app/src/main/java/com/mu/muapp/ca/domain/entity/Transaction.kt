package com.mu.muapp.ca.domain.entity

import org.joda.time.DateTime

data class Transaction(
    val amount: String,
    val date: DateTime,
    val description: String,
    val id: String,
    val otherAccount: String
) {
    val amountFloat: Float = amount.toFloat()
}