package com.asynclabs.asyncsport.ui.athletes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asynclabs.asyncsport.api.Athlete
import com.asynclabs.asyncsport.api.model.AthleteResponse

import com.asynclabs.asyncsport.api.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AthletesViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val athleteList = MutableLiveData<List<AthleteResponse>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllAthletes() {

        val response = repository.getAthletes()
        response.enqueue(object : Callback<List<AthleteResponse>> {
            override fun onResponse(call: Call<List<AthleteResponse>>, response: Response<List<AthleteResponse>>) {
                athleteList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<AthleteResponse>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}