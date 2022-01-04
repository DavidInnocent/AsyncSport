package com.asynclabs.asyncsport.api.retrofit

import com.asynclabs.asyncsport.api.Athlete
import com.asynclabs.asyncsport.api.FeedResponse
import com.asynclabs.asyncsport.api.model.AthleteResponse


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("feed")
    fun getFeeds(@Query("page") page:Int, @Query("sport")sport:String) : Call<List<FeedResponse>>

    @GET("athlete")
    fun getAthletes() : Call<List<AthleteResponse>>

}