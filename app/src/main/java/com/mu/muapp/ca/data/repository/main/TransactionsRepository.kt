package com.mu.muapp.ca.data.repository.main

import com.mu.muapp.ca.data.source.api.response.TransactionsResponse
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * NO API provided for test assignment, so this repo is just a dummy to show approach with switching of repos
 * according to build type.
 */
class TransactionsRepository @Inject constructor() : ITransactionsRepository {

    override fun getTransactions(): Single<TransactionsResponse> {
        return Single.just(TransactionsResponse("", "", emptyList())).delay(5, TimeUnit.SECONDS)
    }

}