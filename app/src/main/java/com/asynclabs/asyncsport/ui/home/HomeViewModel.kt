package com.asynclabs.asyncsport.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asynclabs.asyncsport.data.FeedResponse
import com.asynclabs.asyncsport.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: MainRepository)  : ViewModel() {

    val feedList = MutableLiveData<List<FeedResponse>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllFeeds(page:Int, sport:String) {

        viewModelScope.launch {
            val response = repository.getAllFeeds(page, sport)
              feedList.postValue(response.body())

        }

    }
}