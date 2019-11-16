package com.prasad.moviedb.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prasad.moviedb.di.ViewModelKey
import com.prasad.moviedb.util.ViewModelFactory
import com.prasad.moviedb.ui.fragment.discover.DiscoverViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module(includes = [AppModule::class, RepositoryModule::class])
abstract class ViewModelModule {

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DiscoverViewModel::class)
    abstract fun bindHomeViewModel(viewModel: DiscoverViewModel): ViewModel

}