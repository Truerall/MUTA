package com.mu.muapp.ca.data.repository.main

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import com.mu.muapp.ca.data.source.api.response.TransactionsResponse
import com.mu.muapp.ca.domain.entity.Transaction
import com.mu.muapp.utils.rx.SchedulerProvider
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy
import java.io.InputStreamReader

class TransactionsRepositoryMock(context: Context, schedulerProvider: SchedulerProvider) : ITransactionsRepository {
    private val transactionsList: MutableList<Transaction> = mutableListOf()

    init {
        Single.fromCallable<List<Transaction>> {
            val data: TransactionsResponse
            val assetManager = context.assets
            val ims = assetManager.open("transactions.json")

            val reader = InputStreamReader(ims)
            data = Gson().fromJson(reader, object : TypeToken<TransactionsResponse>() {}.type)

            if (data == null) {
                throw JsonParseException("Bad json object")
            }
            return@fromCallable data.transactions
        }.subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.io())
            .subscribeBy(
                onSuccess = { transactionsList.addAll(it) },
                onError = { println("provide correct transactions.json file to assets folder") }
            )
    }

    override fun getTransactions(): List<Transaction> {
        return transactionsList
    }
}