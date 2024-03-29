package com.prasad.moviedb.ui.fragment.discover

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableList
import com.prasad.moviedb.util.SingleLiveEvent
import com.prasad.moviedb.data.local.enitity.DiscoverEntity
import com.prasad.moviedb.data.repository.DiscoverRepository
import com.prasad.moviedb.util.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DiscoverViewModel @Inject constructor(
    private val discoverRepository: DiscoverRepository
) : BaseViewModel() {

    private val isRefreshing = ObservableBoolean(false)
    private val items: ObservableList<DiscoverEntity> = ObservableArrayList()
    private val onDiscoverOpenEvent = SingleLiveEvent<DiscoverEntity>()

    private var disposable: Disposable? = null

    override fun start() {
        getAllDiscover(false)
    }

    override fun stop() {
        disposable?.let { if (!it.isDisposed) it.dispose() }
    }

   fun getAllDiscover(isRefresh: Boolean) {
        disposable = discoverRepository.getAllDiscoverMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isRefreshing.set(true) }
            .doAfterTerminate { isRefreshing.set(false) }
            .subscribe({ discover ->
                with(items) {
                    clear()
                    addAll(discover)
                }
            }, { error ->
                error.printStackTrace()
            })
    }
}