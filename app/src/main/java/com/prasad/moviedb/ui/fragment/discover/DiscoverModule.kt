package com.prasad.moviedb.ui.fragment.discover

import com.kotlin.mvvm.boilerplate.di.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DiscoverModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindDiscoverFragment(): DiscoverFragment
}