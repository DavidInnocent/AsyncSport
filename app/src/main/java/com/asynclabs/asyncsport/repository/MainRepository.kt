package com.asynclabs.asyncsport.repository

import com.asynclabs.asyncsport.api.retrofit.RetrofitService


class MainRepository (private val retrofitService: RetrofitService) {
    suspend fun getAllFeeds(page:Int, sport:String) = retrofitService.getFeeds(page, sport)
    suspend fun getAthletes() = retrofitService.getAthletes()
}