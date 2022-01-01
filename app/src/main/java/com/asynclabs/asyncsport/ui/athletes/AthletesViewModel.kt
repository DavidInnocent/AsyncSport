package com.asynclabs.asyncsport.ui.athletes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AthletesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is athletes Fragment"
    }
    val text: LiveData<String> = _text
}