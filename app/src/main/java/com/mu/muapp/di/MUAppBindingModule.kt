package com.mu.muapp.di

import com.mu.muapp.ca.data.repository.main.ITransactionsRepository
import com.mu.muapp.ca.data.repository.main.TransactionsRepository
import com.mu.muapp.ca.data.repository.main.TransactionsRepositoryMock
import com.mu.muapp.utils.rx.AppSchedulerProvider
import com.mu.muapp.utils.rx.ISchedulerProvider
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
abstract class MUAppBindingModule {
    @Named("mock")
    @Binds
    abstract fun bindTransactionsRepositoryMock(transactionsRepositoryMock: TransactionsRepositoryMock): ITransactionsRepository

    @Named("debug")
    @Binds
    abstract fun bindTransactionsRepositoryDebug(transactionsRepository: TransactionsRepository): ITransactionsRepository

    @Named("release")
    @Binds
    abstract fun bindTransactionsRepositoryRelease(transactionsRepository: TransactionsRepository): ITransactionsRepository

    @Binds
    abstract fun bindSchedulerProvider(appSchedulerProvider: AppSchedulerProvider): ISchedulerProvider
}