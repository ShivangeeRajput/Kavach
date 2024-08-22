package com.example.kavach.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object ThoughtRepository {
    private val thoughtLiveData = MutableLiveData<Pair<String, String>>()

    fun updateThought(title: String, message: String) {
        thoughtLiveData.postValue(Pair(title, message))
    }

    fun getThought(): LiveData<Pair<String, String>> = thoughtLiveData
}
