package com.mu.muapp.di

import com.mu.muapp.ca.data.repository.main.ITransactionsRepository
import com.mu.muapp.ca.data.repository.main.TransactionsRepository
import com.mu.muapp.ca.data.repository.main.TransactionsRepositoryMock
import com.mu.muapp.utils.rx.AppSchedulerProvider
import com.mu.muapp.utils.rx.ISchedulerProvider
import dagger.Binds
import dagger.Module
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class MUAppBindingModule {
    @Singleton
    @Named("mock")
    @Binds
    abstract fun bindTransactionsRepositoryMock(transactionsRepositoryMock: TransactionsRepositoryMock): ITransactionsRepository

    @Singleton
    @Named("debug")
    @Binds
    abstract fun bindTransactionsRepositoryDebug(transactionsRepository: TransactionsRepository): ITransactionsRepository

    @Singleton
    @Named("release")
    @Binds
    abstract fun bindTransactionsRepositoryRelease(transactionsRepository: TransactionsRepository): ITransactionsRepository

    @Singleton
    @Binds
    abstract fun bindSchedulerProvider(appSchedulerProvider: AppSchedulerProvider): ISchedulerProvider
}