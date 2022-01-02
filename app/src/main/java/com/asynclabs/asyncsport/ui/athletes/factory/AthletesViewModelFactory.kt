package com.asynclabs.asyncsport.ui.athletes.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.asynclabs.asyncsport.api.repository.MainRepository
import com.asynclabs.asyncsport.ui.athletes.AthletesViewModel
import com.asynclabs.asyncsport.ui.home.HomeViewModel

class AthletesViewModelFactory constructor(private val repository: MainRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(AthletesViewModel::class.java)) {
            AthletesViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}