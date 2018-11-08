package com.mu.muapp.di.main

import com.mu.muapp.ca.presentation.view.main.fragments.details.TransactionsDetailsFragment
import com.mu.muapp.ca.presentation.view.main.fragments.list.TransactionsListFragment
import com.mu.muapp.di.main.fragments.TransactionDetailsFragmentModule
import com.mu.muapp.di.main.fragments.TransactionListFragmentModule
import com.mu.muapp.di.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentBuilder{
    @FragmentScope
    @ContributesAndroidInjector(modules = [TransactionListFragmentModule::class])
    abstract fun bindTransactionsListFragment(): TransactionsListFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [TransactionDetailsFragmentModule::class])
    abstract fun bindTransactionsDetailsFragment(): TransactionsDetailsFragment
}