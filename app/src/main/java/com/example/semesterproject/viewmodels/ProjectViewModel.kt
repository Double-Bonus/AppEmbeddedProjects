package com.example.semesterproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semesterproject.database.ProjectDatabase
import com.example.semesterproject.models.Project
import kotlinx.coroutines.launch

class ProjectViewModel(private val db: ProjectDatabase) : ViewModel() {
    private val _projects = MutableLiveData<List<Project>>()
    val projects: LiveData<List<Project>>
        get() = _projects

    //val database = Room.databaseBuilder(context, ProjectDatabase::class.java, "projects").build()

    init {
        getAllProjects()
    }

    fun getAllProjects() {
        viewModelScope.launch {
            _projects.postValue(db.projectDao().getAll())
        }
    }

    //TODO !!!!

    fun addActor(fullName: String?, birthYear: String?, movie: String?) {
        if (fullName != null && birthYear != null && movie != null) {
            birthYear.toIntOrNull()?.let {
                val project = Project(0, fullName, it,
                        "file:///android_asset/new_prcjt.png",
                        true, false, true, false,
                false, false, true, true, false, true, false, false,
                false)
                viewModelScope.launch {
                    db.projectDao().insertAll(project)
                    getAllProjects()
                }
            }
        }
    }
    /*
   fun addActor(){
       viewModelScope.launch {
           db.projectDao().insertAll(MockData.getProjectMock())
           getAllProjects()
       }
   }
*/



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
                _projects.postValue(db.projectDao().getEasier(it))
            }
        }
    }

    private fun getAllFromMovie(movie: String?) {
        movie?.let {
            viewModelScope.launch {
                _projects.postValue(db.projectDao().getByName(movie))
            }
        }
    }

    fun deleteActor(project: Project) {
        viewModelScope.launch {
            //db.projectDao().deleteProject(project) //TODO
            getAllProjects()
        }
    }
}