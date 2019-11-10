package com.prasad.moviedb


import android.content.Context
import com.facebook.stetho.Stetho
import com.prasad.moviedb.di.appcomponent.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class MainApplication: DaggerApplication() {

    private lateinit var androidInjector: AndroidInjector<out DaggerApplication>

    override fun onCreate() {
        super.onCreate()

        // Initialize Stetho
        Stetho.initializeWithDefaults(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
         androidInjector = DaggerAppComponent.builder().application(this).build()
    }

    public override fun applicationInjector(): AndroidInjector<out DaggerApplication> = androidInjector

}