package com.asynclabs.asyncsport.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asynclabs.asyncsport.api.FeedResponse
import com.asynclabs.asyncsport.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val feedList = MutableLiveData<List<FeedResponse>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllFeeds(page:Int,sport:String) {

        val response = repository.getAllMovies(page, sport)
        response.enqueue(object : Callback<List<FeedResponse>> {
            override fun onResponse(call: Call<List<FeedResponse>>, response: Response<List<FeedResponse>>) {
                feedList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<FeedResponse>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}