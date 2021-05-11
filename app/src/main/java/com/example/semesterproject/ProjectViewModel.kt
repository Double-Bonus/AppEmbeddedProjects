package com.example.semesterproject

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch

class ProjectViewModel(context: Context) : ViewModel() {
    private val _projects = MutableLiveData<List<Project>>()
    val projects: LiveData<List<Project>>
        get() = _projects

    val database = Room.databaseBuilder(context, ProjectDatabase::class.java, "projects").build()

    init {
        getAllProjects()
    }

    fun getAllProjects() {
        viewModelScope.launch {
            _projects.postValue(database.projectDao().getAll())
        }
    }

    //TODO !!!!
    fun addActor(fullName: String?, birthYear: String?, movie: String?) {
        if (fullName != null && birthYear != null && movie != null) {
            birthYear.toIntOrNull()?.let {
                val project = Project(0, fullName, it, true, false, true, false,
                false)
                viewModelScope.launch {
                    database.projectDao().insertProject(project)
                    getAllProjects()
                }
            }
        }
    }

    //TODO !!!!
    fun filter(year: String?, movie: String?) {
        if (!year.isNullOrEmpty()) {
            getAllYounger(year)
        } else if (!movie.isNullOrEmpty()) {
            getAllFromMovie(movie)
        } else {
            getAllProjects()
        }
    }

    private fun getAllYounger(year: String?) {
        year?.toIntOrNull()?.let {
            viewModelScope.launch {
                _projects.postValue(database.projectDao().getEasier(it))
            }
        }
    }

    private fun getAllFromMovie(movie: String?) {
        movie?.let {
            viewModelScope.launch {
                _projects.postValue(database.projectDao().getByName(movie))
            }
        }
    }

    fun deleteActor(project: Project) {
        viewModelScope.launch {
            database.projectDao().deleteProject(project)
            getAllProjects()
        }
    }
}