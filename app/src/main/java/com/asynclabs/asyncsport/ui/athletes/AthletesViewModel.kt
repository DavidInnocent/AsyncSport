package com.asynclabs.asyncsport.ui.athletes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asynclabs.asyncsport.data.model.AthleteResponse

import com.asynclabs.asyncsport.data.repository.impl.AthletesRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AthletesViewModel @Inject constructor(private val repository: AthletesRepositoryImpl) : ViewModel() {

    val athleteList = MutableLiveData<List<AthleteResponse>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllAthletes() {

        viewModelScope.launch {
            val response = repository.getAthletes()
            athleteList.postValue(response.body())

        }

    }
}