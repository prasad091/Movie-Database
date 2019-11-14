package com.prasad.moviedb.ui.fragment.discover

import com.prasad.moviedb.di.FragmentScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DiscoverModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindDiscoverFragment(): DiscoverFragment
}