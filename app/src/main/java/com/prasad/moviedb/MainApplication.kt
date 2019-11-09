package com.prasad.moviedb

import android.app.Activity
import android.app.Application
import com.prasad.moviedb.di.module.DatabaseModule
import com.prasad.moviedb.di.module.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainApplication: Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
/*        DaggerApplicationComponent.builder()
            .application(this)
            .databaseModule(DatabaseModule())
            .networkModule(NetworkModule())
            .build()
            .inject(this)*/
    }
}