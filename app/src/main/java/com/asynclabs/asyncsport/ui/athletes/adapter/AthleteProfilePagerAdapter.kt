package com.asynclabs.asyncsport.ui.athletes.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.asynclabs.asyncsport.api.FeedResponse
import com.asynclabs.asyncsport.api.model.AthleteResponse
import com.asynclabs.asyncsport.databinding.AthleteFeedItemBinding
import com.asynclabs.asyncsport.databinding.VideoFeedItemBinding
import com.potyvideo.library.AndExoPlayerView


class AthleteProfilePagerAdapter :
    ListAdapter<AthleteResponse, AthleteProfilePagerAdapter.ViewPagerViewHolder>(diffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=ViewPagerViewHolder(
        AthleteFeedItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {

        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size


    inner class ViewPagerViewHolder(private val binding: AthleteFeedItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(athleteResponse: AthleteResponse){
            binding.apply {
                this.textView.text=athleteResponse.name
            }
        }

    }

    companion object{
        var diffCallback: DiffUtil.ItemCallback<AthleteResponse> =
            object : DiffUtil.ItemCallback<AthleteResponse>() {

                override fun areItemsTheSame(
                    oldItem: AthleteResponse,
                    newItem: AthleteResponse
                ): Boolean {
                    return oldItem.id == newItem.id
                }


                override fun areContentsTheSame(
                    oldItem: AthleteResponse,
                    newItem: AthleteResponse
                ): Boolean {
                    return oldItem == newItem
                }
            }


    }

}