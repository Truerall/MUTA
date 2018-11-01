package com.mu.muapp.di

import android.app.Application
import com.mu.muapp.MUApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        MUAppProviderModule::class,
        MUAppBindingModule::class]
)
interface MUAppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): MUAppComponent.Builder

        fun build(): MUAppComponent
    }

    fun inject(instance: MUApp)
}