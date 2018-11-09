package com.mu.muapp.ca.domain.entity

import org.joda.time.DateTime
import java.math.BigDecimal

data class Transaction(
    val amount: String,
    val date: DateTime,
    val description: String,
    val id: String,
    val otherAccount: String
) {
    val amountFloat: BigDecimal get() {
        return amount.toBigDecimal()
    }
    var amountBefore: BigDecimal = BigDecimal.ONE
    var amountAfter: BigDecimal = BigDecimal.ONE
}