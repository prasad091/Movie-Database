package com.prasad.moviedb.ui.fragment.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.prasad.moviedb.base.ScopedFragment
import com.prasad.moviedb.databinding.DiscoverFragmentBinding
import javax.inject.Inject

class DiscoverFragment : ScopedFragment() {

    companion object {
        fun newInstance() = DiscoverFragment()
    }
    @Inject
    internal lateinit var discoverFactory: DiscoverFactory
    private lateinit var viewModel: DiscoverViewModel
    private lateinit var binding: DiscoverFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DiscoverFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,this.discoverFactory).get(DiscoverViewModel::class.java)

    }

}
