package com.mu.muapp.ca.domain.usecase.main

import com.mu.muapp.BuildConfig
import com.mu.muapp.ca.data.repository.main.ITransactionsRepository
import com.mu.muapp.ca.domain.entity.Transaction
import com.mu.muapp.ca.domain.usecase.base.SingleUseCase
import com.mu.muapp.utils.rx.ISchedulerProvider
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class GetTransactionDetailsUseCase
@Inject
constructor(
    schedulerProvider: ISchedulerProvider,
    @Named(BuildConfig.BUILD_TYPE) private val iTransactionsRepository: ITransactionsRepository
) : SingleUseCase<Transaction, String>(schedulerProvider.io(), schedulerProvider.ui()) {

    override fun buildUseCaseSingle(params: String?): Single<Transaction> {
        return iTransactionsRepository.getTransaction(params ?: "")
    }
}