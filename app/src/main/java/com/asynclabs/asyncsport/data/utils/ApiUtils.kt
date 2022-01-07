package com.asynclabs.asyncsport.data.utils

import android.util.Log
import retrofit2.Response


suspend fun <T: Any> safeApiCall(call : suspend () -> Response<List<T>>,tag:String): List<T>{
    return try {
        val result=call()
        when(result.isSuccessful){
            true -> {
                result.body()?: throw NullPointerException("Null response body")
            }
            false -> {
                Log.d(tag, "getAthletes: ")
                return emptyList<T>()
            }
        }
    } catch(exception:Exception) {
        Log.d(tag, exception.localizedMessage)
        return emptyList()
    }
}