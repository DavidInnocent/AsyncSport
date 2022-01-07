package com.asynclabs.asyncsport.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asynclabs.asyncsport.data.FeedResponse
import com.asynclabs.asyncsport.data.repository.AthletesRepository
import com.asynclabs.asyncsport.data.repository.FeedsRepository
import com.asynclabs.asyncsport.data.repository.impl.AthletesRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: FeedsRepository)  : ViewModel() {

    val feedList = MutableLiveData<List<FeedResponse>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllFeeds(page:Int, sport:String) {

        viewModelScope.launch {
            val feedsResult = repository.getAllFeeds(page, sport)
            when(feedsResult.isEmpty()){
                true -> errorMessage.postValue("An error has occurred")
                false -> feedList.postValue(feedsResult)
            }
        }

    }
}