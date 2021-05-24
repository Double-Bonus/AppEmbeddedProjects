package com.example.semesterproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.semesterproject.database.ProjectDatabase

class ProjectPhotoViewModelFactory (private val db: ProjectDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProjectPhotoViewModel::class.java)) {
            return ProjectPhotoViewModel(db) as T
        }
        throw IllegalArgumentException()
    }
}