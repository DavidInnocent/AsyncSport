package com.asynclabs.asyncsport.data.repository.impl

import com.asynclabs.asyncsport.data.FeedResponse
import com.asynclabs.asyncsport.data.remote.AsyncLabAPI
import com.asynclabs.asyncsport.data.repository.FeedsRepository
import com.asynclabs.asyncsport.data.utils.safeApiCall


class FeedsRepositoryImpl (private val retrofitService: AsyncLabAPI):FeedsRepository {
    private val TAG = FeedsRepositoryImpl::class.java.simpleName
    override suspend fun getAllFeeds(page: Int, sport: String): List<FeedResponse> {
        return safeApiCall (
            call = { retrofitService.getFeeds(page, sport) },
            tag = TAG
        )

    }
}