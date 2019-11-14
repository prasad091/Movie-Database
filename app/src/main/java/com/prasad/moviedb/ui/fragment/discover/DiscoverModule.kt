package com.prasad.moviedb.ui.fragment.discover

import com.kotlin.mvvm.boilerplate.di.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DiscoverModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindDiscoverFragment(): DiscoverFragment
}