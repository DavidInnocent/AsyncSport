package com.asynclabs.asyncsport.data.remote

import com.asynclabs.asyncsport.data.FeedResponse
import com.asynclabs.asyncsport.data.model.AthleteResponse


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AsyncLabAPI {
    @GET("feed")
    suspend fun getFeeds(@Query("page") page:Int, @Query("sport")sport:String) : Response<List<FeedResponse>>

    @GET("athlete")
    suspend fun getAthletes() : Response<List<AthleteResponse>>

}