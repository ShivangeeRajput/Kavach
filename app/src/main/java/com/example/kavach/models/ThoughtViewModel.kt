package com.example.kavach.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kavach.repository.ThoughtRepository

class ThoughtViewModel : ViewModel() {
    private val thoughtLiveData = ThoughtRepository.getThought()

    fun getThoughtOfTheDay(): LiveData<Pair<String, String>> {
        return thoughtLiveData
    }
}
