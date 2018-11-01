package com.mu.muapp.di

import com.mu.muapp.ca.data.repository.main.ITransactionsRepository
import com.mu.muapp.ca.data.repository.main.TransactionsRepositoryMock
import com.mu.muapp.utils.rx.AppSchedulerProvider
import com.mu.muapp.utils.rx.ISchedulerProvider
import dagger.Binds
import dagger.Module

@Module
abstract class MUAppBindingModule {

    @Binds
    abstract fun bindTransactionsRepository(transactionsRepositoryMock: TransactionsRepositoryMock): ITransactionsRepository

    @Binds
    abstract fun bindSchedulerProvider(appSchedulerProvider: AppSchedulerProvider): ISchedulerProvider
}