package com.prasad.moviedb.di.module

import com.prasad.moviedb.ui.fragment.discover.DiscoverFragment
import com.prasad.moviedb.ui.fragment.nowplaying.NowPlayingFragment
import com.prasad.moviedb.ui.fragment.setting.SettingFragment
import com.prasad.moviedb.ui.fragment.upcoming.UpcomingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    /*
     * We define the name of the Fragment we are going
    * to inject the ViewModelFactory into. i.e. in our case
    * The name of the fragment: MovieListFragment
    */
    @ContributesAndroidInjector
    abstract fun contributeDiscoverFragment(): DiscoverFragment

    @ContributesAndroidInjector
    abstract fun contributeNowPlayingFragment(): NowPlayingFragment

    @ContributesAndroidInjector
    abstract fun contributeUpcomingFragment(): UpcomingFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingFragment(): SettingFragment
}