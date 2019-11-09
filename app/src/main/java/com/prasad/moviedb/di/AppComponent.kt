package com.prasad.moviedb.di

import android.app.Application
import com.prasad.moviedb.MainApplication
import com.prasad.moviedb.di.module.ActivityModule
import com.prasad.moviedb.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class,
    AndroidSupportInjectionModule::class,
    NetworkModule::class])
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}