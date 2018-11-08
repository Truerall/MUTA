package com.mu.muapp.ca.data.repository.main

import android.app.Application
import com.google.gson.Gson
import com.google.gson.JsonParseException
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
            val data: TransactionsResponse
            val assetManager = context.assets
            val ims = assetManager.open("transactions.json")

            val reader = InputStreamReader(ims)
            data = gson.fromJson(reader, object : TypeToken<TransactionsResponse>() {}.type)

            if (data == null) {
                throw JsonParseException("Bad json object")
            }
            return@fromCallable data
        }.delay(5, TimeUnit.SECONDS)
    }
}