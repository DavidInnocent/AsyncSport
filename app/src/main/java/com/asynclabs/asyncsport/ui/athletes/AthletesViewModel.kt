package com.asynclabs.asyncsport.ui.athletes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asynclabs.asyncsport.data.model.AthleteResponse
import com.asynclabs.asyncsport.data.repository.AthletesRepository

import com.asynclabs.asyncsport.data.repository.impl.AthletesRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AthletesViewModel @Inject constructor(private val repository: AthletesRepository) : ViewModel() {

    val athleteList = MutableLiveData<List<AthleteResponse>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllAthletes() {

        viewModelScope.launch {
            val athletesResult = repository.getAthletes()
            when(athletesResult.isEmpty()){
                true -> errorMessage.postValue("An error has occurred")
                false -> athleteList.postValue(athletesResult)
            }
            

        }

    }
}