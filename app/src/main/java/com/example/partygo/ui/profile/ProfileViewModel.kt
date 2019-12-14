package com.example.partygo.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.partygo.user1

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = user1.Name
    }
    val text: LiveData<String> = _text
}