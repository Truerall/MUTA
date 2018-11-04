package com.mu.muapp.di.main.fragments

import com.mu.muapp.ca.presentation.presenters.main.fragments.details.TransactionDetailsContract
import com.mu.muapp.ca.presentation.presenters.main.fragments.details.TransactionDetailsPresenter
import com.mu.muapp.di.scopes.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class TransactionDetailsFragmentModule {

    @FragmentScope
    @Binds
    abstract fun providePresenter(transactionDetailsPresenter: TransactionDetailsPresenter): TransactionDetailsContract.ITransactionDetailsPresenter

}