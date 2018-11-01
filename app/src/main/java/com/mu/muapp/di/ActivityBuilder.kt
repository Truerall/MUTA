package com.mu.muapp.di

import com.mu.muapp.ca.presentation.view.main.MainActivity
import com.mu.muapp.di.main.MainActivityFragmentBuilder
import com.mu.muapp.di.main.MainActivityModule
import com.mu.muapp.di.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainActivityFragmentBuilder::class])
    internal abstract fun bindMainActivity(): MainActivity
}