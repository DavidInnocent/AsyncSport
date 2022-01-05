package com.asynclabs.asyncsport.data.repository

import com.asynclabs.asyncsport.data.remote.AsyncLabAPI


class MainRepository (private val retrofitService: AsyncLabAPI) {
    suspend fun getAllFeeds(page:Int, sport:String) = retrofitService.getFeeds(page, sport)
    suspend fun getAthletes() = retrofitService.getAthletes()
}