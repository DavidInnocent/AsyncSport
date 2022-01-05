package com.asynclabs.asyncsport.data.repository

import com.asynclabs.asyncsport.data.FeedResponse

interface FeedsRepository {
    suspend fun getAllFeeds(page:Int, sport:String):List<FeedResponse>
}