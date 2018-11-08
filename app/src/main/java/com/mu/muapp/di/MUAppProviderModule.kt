package com.mu.muapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mu.muapp.utils.gson.DateDeserializer
import dagger.Module
import dagger.Provides
import org.joda.time.DateTime
import javax.inject.Singleton


@Module
class MUAppProviderModule {

    @Provides
    @Singleton
    fun provideGSON(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(DateTime::class.java, DateDeserializer())
        return gsonBuilder.create()
    }
}