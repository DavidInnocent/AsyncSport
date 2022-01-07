package com.asynclabs.asyncsport.data.repository

import com.asynclabs.asyncsport.data.model.AthleteResponse

interface AthletesRepository {
    suspend fun getAthletes():List<AthleteResponse>
}