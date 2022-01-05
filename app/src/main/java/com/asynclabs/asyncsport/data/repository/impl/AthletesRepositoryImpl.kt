package com.asynclabs.asyncsport.data.repository.impl

import android.util.Log
import com.asynclabs.asyncsport.data.model.AthleteResponse
import com.asynclabs.asyncsport.data.remote.AsyncLabAPI
import com.asynclabs.asyncsport.data.repository.AthletesRepository
import com.asynclabs.asyncsport.data.utils.safeApiCall
import retrofit2.Response


class AthletesRepositoryImpl (private val retrofitService: AsyncLabAPI):AthletesRepository {
    private val TAG = AthletesRepositoryImpl::class.java.simpleName
    override suspend fun getAthletes(): List<AthleteResponse> {
        return safeApiCall (
            call = { retrofitService.getAthletes() },
            tag = TAG
        )

    }
}