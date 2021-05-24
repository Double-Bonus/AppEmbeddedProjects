package com.example.semesterproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semesterproject.database.ProjectDatabase
import com.example.semesterproject.models.Project
import kotlinx.coroutines.launch

class ProjectPhotoViewModel (private val db: ProjectDatabase) : ViewModel() {
    private val _projectsPh = MutableLiveData<List<Project>>()
    val projectsPh: LiveData<List<Project>>
        get() = _projectsPh

    init {
        getAllProjects()
    }

    fun getAllProjects() {
        viewModelScope.launch {
            _projectsPh.postValue(db.projectDao().getAll())
        }
    }

}