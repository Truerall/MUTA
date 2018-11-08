package com.mu.muapp.ca.domain.usecase.main

import com.mu.muapp.BuildConfig
import com.mu.muapp.ca.data.repository.main.ITransactionsRepository
import com.mu.muapp.ca.data.source.api.response.TransactionsResponse
import com.mu.muapp.ca.domain.usecase.base.SingleUseCase
import com.mu.muapp.utils.rx.ISchedulerProvider
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class GetTransactionsUseCase
@Inject
constructor(
    schedulerProvider: ISchedulerProvider,
    @Named(BuildConfig.BUILD_TYPE) private val iTransactionsRepository: ITransactionsRepository
) : SingleUseCase<TransactionsResponse, Unit>(schedulerProvider.io(), schedulerProvider.ui()) {

    override fun buildUseCaseSingle(params: Unit?): Single<TransactionsResponse> {
        return iTransactionsRepository.getTransactions()
    }
}