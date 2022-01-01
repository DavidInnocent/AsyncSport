package com.asynclabs.asyncsport.ui.athletes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asynclabs.asyncsport.api.FeedResponse
import com.asynclabs.asyncsport.api.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AthletesViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val athleteList = MutableLiveData<List<FeedResponse>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllAthletes(page:Int,sport:String) {

        val response = repository.getAthletes(page, sport)
        response.enqueue(object : Callback<List<FeedResponse>> {
            override fun onResponse(call: Call<List<FeedResponse>>, response: Response<List<FeedResponse>>) {
                athleteList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<FeedResponse>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}