package com.prasad.moviedb.di.module

import com.kotlin.mvvm.boilerplate.di.ActivityScoped
import com.prasad.moviedb.ui.activity.MainActivity
import com.prasad.moviedb.ui.fragment.discover.DiscoverModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [DiscoverModule::class])
    internal abstract fun bindMainActivity(): MainActivity


}