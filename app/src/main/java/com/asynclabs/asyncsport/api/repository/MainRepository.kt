package com.asynclabs.asyncsport.api.repository

import com.asynclabs.asyncsport.api.retrofit.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies(page:Int,sport:String) = retrofitService.getFeeds(page, sport)
    fun getAthletes() = retrofitService.getAthletes()
}