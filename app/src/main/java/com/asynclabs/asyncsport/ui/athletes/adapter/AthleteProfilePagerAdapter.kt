package com.asynclabs.asyncsport.ui.athletes.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import com.bumptech.glide.Glide


import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.asynclabs.asyncsport.R

import com.asynclabs.asyncsport.data.model.AthleteResponse
import com.asynclabs.asyncsport.databinding.AthleteFeedItemBinding
import javax.inject.Inject


class AthleteProfilePagerAdapter @Inject constructor() :
    ListAdapter<AthleteResponse, AthleteProfilePagerAdapter.ViewPagerViewHolder>(diffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewPagerViewHolder(
        AthleteFeedItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {

        val athlete=currentList[position];
        if(position==currentList.size-1)holder.itemView.findViewById<LottieAnimationView>(R.id.animationView).visibility=
            View.GONE
        holder.bind(athlete)
    }

    override fun getItemCount(): Int = currentList.size


    inner class ViewPagerViewHolder(private val binding: AthleteFeedItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(athleteResponse: AthleteResponse) {
            binding.apply {

                this.clubTextView.text = athleteResponse.club
//                this.playerImageView.=athleteResponse.club

                this.firstNameTextview.text =
                    athleteResponse.name?.split(" ")?.toTypedArray()?.get(0) ?: ""
                this.lastNameTextView.text =
                    athleteResponse.name?.split(" ")?.toTypedArray()?.get(1) ?: ""
//                Glide.with(binding.root.context).load(athleteResponse.avatar.).into(playerImageView)

                var avatarUrl = athleteResponse.avatar
                if (avatarUrl?.contains("open?id") ?: "" == true) {
                    var avatarStringArray = athleteResponse.avatar?.split("open?id")?.toTypedArray()
                    avatarUrl =
                        "https://drive.google.com/uc?id" + (avatarStringArray?.get(1) ?: "")
                }

                Glide.with(binding.root.context)
                    .load(Uri.parse(avatarUrl))
                    .fitCenter()
                    .into(playerImageView)

                Glide.with(binding.root.context).load(athleteResponse.country?.icon)
                    .into(countryImageview)
                Glide.with(binding.root.context).load(athleteResponse.sport?.icon).into(imageView4)
            }
        }

    }

    companion object {
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