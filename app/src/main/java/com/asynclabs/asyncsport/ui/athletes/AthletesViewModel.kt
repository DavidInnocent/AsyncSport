package com.asynclabs.asyncsport.ui.athletes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asynclabs.asyncsport.api.model.AthleteResponse

import com.asynclabs.asyncsport.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AthletesViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    val athleteList = MutableLiveData<List<AthleteResponse>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllAthletes() {

        viewModelScope.launch {
            val response = repository.getAthletes()
            athleteList.postValue(response.body())

        }

    }
}