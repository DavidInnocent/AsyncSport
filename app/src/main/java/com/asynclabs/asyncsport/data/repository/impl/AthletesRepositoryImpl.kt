package com.asynclabs.asyncsport.data.repository.impl

import android.util.Log
import com.asynclabs.asyncsport.data.model.AthleteResponse
import com.asynclabs.asyncsport.data.remote.AsyncLabAPI
import com.asynclabs.asyncsport.data.repository.AthletesRepository


class AthletesRepositoryImpl (private val retrofitService: AsyncLabAPI):AthletesRepository {
    private val TAG = AthletesRepositoryImpl::class.java.simpleName
    override suspend fun getAthletes(): List<AthleteResponse> {
        val athletesResponse= retrofitService.getAthletes()
        return try {
            when(athletesResponse.isSuccessful){
                true -> {
                    athletesResponse.body()?: throw NullPointerException("Null response body")
                }
                false -> {
                    Log.d(TAG, "getAthletes: ")
                    return emptyList()
                }
            }
        } catch(exception:Exception) {
            Log.d(TAG, exception.localizedMessage)
            return emptyList()
        }

    }

}