package com.mu.muapp.ca.data.repository.main

import android.app.Application
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mu.muapp.ca.data.source.api.response.TransactionsResponse
import com.mu.muapp.ca.domain.entity.Transaction
import io.reactivex.Single
import java.io.InputStreamReader
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class TransactionsRepositoryMock @Inject constructor(
    private val context: Application,
    private val gson: Gson
) : ITransactionsRepository {

    companion object {
        const val REQUEST_DELAY_TIME: Long = 5
    }

    val cache: MutableList<Transaction> = mutableListOf()

    override fun getTransactions(): Single<TransactionsResponse> {
        return Single.fromCallable<TransactionsResponse> {
            var data: TransactionsResponse
            val assetManager = context.assets
            val ims = assetManager.open("transactions.json")

            val reader = InputStreamReader(ims)
            data = gson.fromJson(reader, object : TypeToken<TransactionsResponse>() {}.type)
            //data = TransactionsResponse(account, balance, emptyList()) // to test empty state
            data = TransactionsResponse(data.account, data.balance, data.transactions.sortedByDescending { it.date })

            with(data) {
                transactions[0].amountAfter = balance.toBigDecimal()
                transactions[0].amountBefore = transactions[0].amountAfter + transactions[0].amountFloat.unaryMinus()

                transactions.forEachIndexed { index, transaction ->
                    with(transaction) {
                        if (index != 0) {
                            amountAfter = transactions[index - 1].amountBefore
                            amountBefore = amountAfter + amountFloat.unaryMinus()
                        }
                    }
                }
            }


            //TODO calculations of current ammount

            cache.addAll(data.transactions)



            return@fromCallable data
        }.delay(Companion.REQUEST_DELAY_TIME, TimeUnit.SECONDS)
    }

    override fun getTransaction(transactionId: String): Single<Transaction> {
        return Single.fromCallable {
            cache.find { it.id == transactionId } ?: throw Exception("Transaction not found")
        }
    }

}