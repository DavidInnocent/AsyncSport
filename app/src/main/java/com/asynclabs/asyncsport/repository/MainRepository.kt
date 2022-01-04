package com.asynclabs.asyncsport.repository

import com.asynclabs.asyncsport.api.retrofit.RetrofitService


class MainRepository (private val retrofitService: RetrofitService) {
    fun getAllMovies(page:Int,sport:String) = retrofitService.getFeeds(page, sport)
    fun getAthletes() = retrofitService.getAthletes()
}