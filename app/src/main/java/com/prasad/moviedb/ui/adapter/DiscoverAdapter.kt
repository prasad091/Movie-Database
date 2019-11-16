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
    private var song: List<DiscoverEntity>,
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
    override fun getItemCount() = song.size

    override fun onBindViewHolder(holder: DiscoverViewHolder, position: Int) =
        holder.bind(song[position], object : SongListener {
            override fun onSongSelected(news: DiscoverEntity) {
                discoverViewModel?.start()
            }
        })

    class DiscoverViewHolder(private val binding: ItemDiscoverListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(discoverEntity: DiscoverEntity, songListener: SongListener) {
            with(binding)
            {
             /*   discover = discoverEntity
                listener = songListener*/
                executePendingBindings()
            }
        }
    }

    fun setData(song: List<DiscoverEntity>) {
        this.song = song
        notifyDataSetChanged()
    }
}

interface SongListener {
    fun onSongSelected(discover: DiscoverEntity)
}