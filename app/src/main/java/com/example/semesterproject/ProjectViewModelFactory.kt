package com.example.semesterproject

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ProjectViewModelFactory (val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProjectViewModel::class.java)) {
            return ProjectViewModel(context) as T
        }
        throw IllegalArgumentException()
    }
}