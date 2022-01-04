package com.asynclabs .asyncsport.ui.home.util.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.asynclabs.asyncsport.api.FeedResponse
import com.asynclabs.asyncsport.databinding.VideoFeedItemBinding

import com.potyvideo.library.AndExoPlayerView


class FeedViewPagerAdapter :
    ListAdapter<FeedResponse, FeedViewPagerAdapter.ViewPagerViewHolder>(diffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder =
        ViewPagerViewHolder(
            VideoFeedItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {

        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size


    inner class ViewPagerViewHolder(private val binding: VideoFeedItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(feedResponse: FeedResponse){
            binding.apply {
                this.textView.text=feedResponse.athlete?.name ?: ""
                this.feedVideo.setVideoURI(Uri.parse(feedResponse.video?.url))
                val mediaController=MediaController(binding.root.context);
                this.feedVideo.setMediaController(mediaController)
                mediaController.setAnchorView(feedVideo)
                feedVideo.start()
            }
        }

    }

    companion object{
        var diffCallback: DiffUtil.ItemCallback<FeedResponse> =
            object : DiffUtil.ItemCallback<FeedResponse>() {

                override fun areItemsTheSame(
                    oldItem: FeedResponse,
                    newItem: FeedResponse
                ): Boolean {
                    return oldItem.id == newItem.id
                }


                override fun areContentsTheSame(
                    oldItem: FeedResponse,
                    newItem: FeedResponse
                ): Boolean {
                    return oldItem == newItem
                }
            }


    }

}