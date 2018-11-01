package com.mu.muapp.ca.domain.entity

data class Transaction(
    val amount: String,
    val date: String,
    val description: String,
    val id: String,
    val otherAccount: String
)