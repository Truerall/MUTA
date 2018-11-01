package com.mu.muapp.di.main

import com.mu.muapp.ca.presentation.view.main.fragments.TransactionsDetailsFragment
import com.mu.muapp.ca.presentation.view.main.fragments.TransactionsListFragment
import com.mu.muapp.di.main.fragments.TransactionDetailsFragmentModule
import com.mu.muapp.di.main.fragments.TransactionListFragmentModule
import com.mu.muapp.di.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentBuilder{
    @FragmentScope
    @ContributesAndroidInjector(modules = [TransactionListFragmentModule::class])
    internal abstract fun bindTransactionsListFragment(): TransactionsListFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [TransactionDetailsFragmentModule::class])
    internal abstract fun bindTransactionsDetailsFragment(): TransactionsDetailsFragment
}