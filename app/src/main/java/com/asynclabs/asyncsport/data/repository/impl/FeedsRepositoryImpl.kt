package com.asynclabs.asyncsport.data.repository.impl

import android.util.Log
import com.asynclabs.asyncsport.data.FeedResponse
import com.asynclabs.asyncsport.data.remote.AsyncLabAPI
import com.asynclabs.asyncsport.data.repository.FeedsRepository


class FeedsRepositoryImpl (private val retrofitService: AsyncLabAPI):FeedsRepository {
    private val TAG = FeedsRepositoryImpl::class.java.simpleName
    override suspend fun getAllFeeds(page: Int, sport: String): List<FeedResponse> {
        val feedsResponse= retrofitService.getFeeds(page,sport)
        return try {
            when(feedsResponse.isSuccessful){
                true -> {
                    feedsResponse.body()?: throw NullPointerException("Null response body")
                }
                false -> {
                    Log.d(TAG, "no athletes found")
                    return emptyList()
                }
            }
        } catch(exception:Exception) {
            Log.d(TAG, exception.localizedMessage)
            return emptyList()
        }

    }
}