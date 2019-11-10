package com.prasad.moviedb.ui.fragment.discover

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prasad.moviedb.data.repository.DiscoverRepo
import javax.inject.Inject

class DiscoverFactory @Inject constructor(
    private val discoverRepo: DiscoverRepo
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DiscoverViewModel(discoverRepo) as T
    }
}