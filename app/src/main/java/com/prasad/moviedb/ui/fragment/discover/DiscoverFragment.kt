package com.prasad.moviedb.ui.fragment.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.prasad.moviedb.di.ActivityScoped
import com.prasad.moviedb.databinding.DiscoverFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

@ActivityScoped
class DiscoverFragment  @Inject constructor(): DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: DiscoverViewModel
    private lateinit var binding: DiscoverFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(DiscoverViewModel::class.java)
        binding = DiscoverFragmentBinding.inflate(inflater, container, false).apply {
            this.discover = viewModel
        }
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.stop()
    }
}
