package com.asynclabs.asyncsport.api.retrofit

import com.asynclabs.asyncsport.api.Athlete
import com.asynclabs.asyncsport.api.FeedResponse


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("feed")
    fun getFeeds(@Query("page") page:Int, @Query("sport")sport:String) : Call<List<FeedResponse>>
    fun getAthletes(@Query("page") page:Int, @Query("sport")sport:String) : Call<List<FeedResponse>>


    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://private-f5748d-technicaltaskapi.apiary-mock.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }

}