package com.asynclabs.asyncsport.data.repository.impl

import com.asynclabs.asyncsport.data.FeedResponse
import com.asynclabs.asyncsport.data.remote.AsyncLabAPI
import com.asynclabs.asyncsport.data.repository.FeedsRepository


class FeedsRepositoryImpl (private val retrofitService: AsyncLabAPI):FeedsRepository {
    override suspend fun getAllFeeds(page: Int, sport: String): List<FeedResponse> {
        TODO("Not yet implemented")
    }

}