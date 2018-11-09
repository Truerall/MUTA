package com.mu.muapp.ca.data.repository.main

import com.mu.muapp.ca.data.source.api.response.TransactionsResponse
import com.mu.muapp.ca.domain.entity.Transaction
import io.reactivex.Single
import org.joda.time.format.DateTimeFormat
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * NO API provided for test assignment, so this repo is just a dummy to show approach with switching of repos
 * according to build type.
 */
class TransactionsRepository @Inject constructor() : ITransactionsRepository {
    override fun getTransaction(transactionId: String): Single<Transaction> {
        val df = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZZ")
        return Single.just(Transaction("", df.withOffsetParsed().parseDateTime("1970-01-01"), "", "", ""))
    }

    override fun getTransactions(): Single<TransactionsResponse> {
        return Single.just(TransactionsResponse("", "", emptyList())).delay(5, TimeUnit.SECONDS)
    }

}