package com.prasad.moviedb.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.prasad.moviedb.R
import com.prasad.moviedb.data.local.enitity.DiscoverEntity
import com.prasad.moviedb.databinding.ItemDiscoverListBinding
import com.prasad.moviedb.ui.fragment.discover.DiscoverViewModel


class DiscoverAdapter(
    private var discover: List<DiscoverEntity>,
    private val discoverViewModel: DiscoverViewModel?
) : RecyclerView.Adapter<DiscoverAdapter.DiscoverViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverViewHolder {
        val binding = DataBindingUtil.inflate<ItemDiscoverListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_discover_list, parent, false
        )

        return DiscoverViewHolder(binding)
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }
    override fun getItemCount() = discover.size

    override fun onBindViewHolder(holder: DiscoverViewHolder, position: Int) =
        holder.bind(discover[position], object : DiscoverListener {
            override fun onDiscoverSelected(news: DiscoverEntity) {
                discoverViewModel?.start()
            }
        })

    class DiscoverViewHolder(private val binding: ItemDiscoverListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(discoverEntity: DiscoverEntity, discoverListener: DiscoverListener) {
            with(binding)
            {
             /*   discover = discoverEntity
                listener = discoverListener*/
                executePendingBindings()
            }
        }
    }

    fun setData(discover: List<DiscoverEntity>) {
        this.discover = discover
        notifyDataSetChanged()
    }
}

interface DiscoverListener {
    fun onDiscoverSelected(discover: DiscoverEntity)
}