package com.prasad.moviedb.di.module

import android.app.Application
import android.content.Context
import com.prasad.moviedb.di.qualifier.ApplicationContext
import com.prasad.moviedb.MainApplication
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    @ApplicationContext
    abstract fun bindApplicationContext(application: MainApplication): Context

    @Binds
    abstract fun bindApplication(application: MainApplication): Application
}