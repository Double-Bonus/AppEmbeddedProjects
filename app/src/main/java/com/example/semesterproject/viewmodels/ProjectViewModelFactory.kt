package com.example.semesterproject.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProjectViewModelFactory (val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProjectViewModel::class.java)) {
            return ProjectViewModel(context) as T
        }
        throw IllegalArgumentException()
    }
}