package com.mu.muapp.ca.data.repository.main

import android.app.Application
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mu.muapp.ca.data.source.api.response.TransactionsResponse
import io.reactivex.Single
import java.io.InputStreamReader
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class TransactionsRepositoryMock @Inject constructor(
    private val context: Application,
    private val gson: Gson
) : ITransactionsRepository {

    override fun getTransactions(): Single<TransactionsResponse> {
        return Single.fromCallable<TransactionsResponse> {
            var data: TransactionsResponse
            val assetManager = context.assets
            val ims = assetManager.open("transactions.json")

            val reader = InputStreamReader(ims)
            data = gson.fromJson(reader, object : TypeToken<TransactionsResponse>() {}.type)

            with(data) {
                data = TransactionsResponse(account, balance, data.transactions.sortedByDescending { it.date })
            }

            //TODO calculations of current ammount

            return@fromCallable data
        }.delay(Companion.REQUEST_DELAY_TIME, TimeUnit.SECONDS)
    }

    companion object {
        const val REQUEST_DELAY_TIME: Long = 3
    }
}