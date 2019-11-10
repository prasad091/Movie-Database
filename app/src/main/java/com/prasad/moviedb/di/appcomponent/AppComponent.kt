package com.prasad.moviedb.di.appcomponent

import com.prasad.moviedb.MainApplication
import com.prasad.moviedb.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, AppModule::class, DatabaseModule::class, NetworkModule::class,
        RepositoryModule::class, ViewModelModule::class, ActivityBindingModule::class]
)
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MainApplication): Builder

        fun build(): AppComponent
    }
}