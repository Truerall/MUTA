package com.mu.muapp.di.main.fragments

import com.mu.muapp.ca.presentation.presenters.main.fragments.list.ITransactionsListFrgViewModel
import com.mu.muapp.ca.presentation.presenters.main.fragments.list.TransactionsListContract
import com.mu.muapp.ca.presentation.presenters.main.fragments.list.TransactionsListPresenter
import com.mu.muapp.ca.presentation.view.main.fragments.list.viewModel.TransactionListFragmentViewModel
import com.mu.muapp.di.scopes.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class TransactionListFragmentModule {

    @FragmentScope
    @Binds
    abstract fun providePresenter(transactionsListPresenter: TransactionsListPresenter): TransactionsListContract.ITransactionsListPresenter

    @FragmentScope
    @Binds
    abstract fun provideViewModel(viewModel: TransactionListFragmentViewModel): ITransactionsListFrgViewModel

}