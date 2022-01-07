package com.asynclabs.asyncsport.ui.home.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.asynclabs.asyncsport.R
import com.asynclabs.asyncsport.data.FeedResponse
import com.asynclabs.asyncsport.databinding.VideoFeedItemBinding
import com.bumptech.glide.Glide
import javax.inject.Inject


class FeedViewPagerAdapter @Inject constructor() :
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

        if(position==currentList.size-1)holder.itemView.findViewById<LottieAnimationView>(R.id.animationView).visibility=
            View.GONE
        val mediaController=MediaController(holder.itemView.context)
        holder.bind(currentList[position],mediaController)
    }

    override fun getItemCount(): Int = currentList.size


    inner class ViewPagerViewHolder(private val binding: VideoFeedItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(feedResponse: FeedResponse, mediaController: MediaController){
            binding.apply {
                this.playerName.text=feedResponse.athlete?.name ?: ""
                this.feedVideo.setVideoURI(Uri.parse(feedResponse.video?.url))
                this.feedVideo.setMediaController(mediaController)
                mediaController.setAnchorView(feedVideo)
                mediaController.contentDescription=feedResponse.description
                feedVideo.start()

                this.description.text= feedResponse.description
                this.views.text=feedResponse.views

                var avatarUrl = feedResponse.athlete?.avatar
                if (avatarUrl?.contains("open?id") ?: "" == true) {
                    var avatarStringArray = feedResponse.athlete?.avatar?.split("open?id")?.toTypedArray()
                    avatarUrl =
                        "https://drive.google.com/uc?id" + (avatarStringArray?.get(1) ?: "")
                }
                Glide.with(binding.root.context)
                    .load(Uri.parse(avatarUrl))
                    .fitCenter()
                    .into(this.playerImage)
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