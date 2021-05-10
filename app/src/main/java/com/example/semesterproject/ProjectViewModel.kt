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
    val actors: LiveData<List<Project>>
        get() = _projects

    val database = Room.databaseBuilder(context, ProjectDatabase::class.java, "actors").build()

    init {
        getAllActors()
    }

    fun getAllActors() {
        viewModelScope.launch {
            _projects.postValue(database.projectDao().getAll())
        }
    }

    fun addActor(fullName: String?, birthYear: String?, movie: String?) {
        if (fullName != null && birthYear != null && movie != null) {
            birthYear.toIntOrNull()?.let {
                val actor = Project(0, fullName, it, Parts(true, false, true, false,
                false))
                viewModelScope.launch {
                    database.projectDao().insertActor(actor)
                    getAllActors()
                }
            }
        }
    }

    fun filter(year: String?, movie: String?) {
        if (!year.isNullOrEmpty()) {
            getAllYounger(year)
        } else if (!movie.isNullOrEmpty()) {
            getAllFromMovie(movie)
        } else {
            getAllActors()
        }
    }

    private fun getAllYounger(year: String?) {
        year?.toIntOrNull()?.let {
            viewModelScope.launch {
                _projects.postValue(database.projectDao().getYounger(it))
            }
        }
    }

    private fun getAllFromMovie(movie: String?) {
        movie?.let {
            viewModelScope.launch {
                _projects.postValue(database.projectDao().getByMovie(movie))
            }
        }
    }

    fun deleteActor(actor: Project) {
        viewModelScope.launch {
            database.projectDao().deleteActor(actor)
            getAllActors()
        }
    }
}