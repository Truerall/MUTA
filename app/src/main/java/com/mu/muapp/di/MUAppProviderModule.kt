package com.mu.muapp.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MUAppProviderModule {

    @Provides
    @Singleton
    fun provideGSON(): Gson {
        return Gson()
    }
}