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

    init {
        getAllProjects()
    }

    fun getAllProjects() {
        viewModelScope.launch {
            _projects.postValue(db.projectDao().getAll())
        }
    }

    //TODO !!!!
    fun addProject(fullName: String?, birthYear: String?, movie: String?) {
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

    //TODO !!!!
    fun filter(diff: String?, name: String?) {
        if (!diff.isNullOrEmpty()) {
            getAllEasier(diff)
        } else if (!name.isNullOrEmpty()) {
            getAllByName(name)
        } else {
            getAllProjects()
        }
    }

    private fun getAllEasier(diff: String?) {
        diff?.toIntOrNull()?.let {
            viewModelScope.launch {
                _projects.postValue(db.projectDao().getEasier(it))
            }
        }
    }

    private fun getAllByName(name: String?) {
        name?.let {
            viewModelScope.launch {
                _projects.postValue(db.projectDao().getByName(name))
            }
        }
    }

    fun deleteProject(project: Project) {
        viewModelScope.launch {
            //db.projectDao().deleteProject(project) //TODO
            getAllProjects()
        }
    }

    fun findProject(dc: Boolean, ble: Boolean,  wheel :Boolean, rtc : Boolean,
                    lcd : Boolean, ul : Boolean, led : Boolean, air : Boolean,
                    mcu : Boolean, acc : Boolean,  hyd : Boolean,  res : Boolean) {
        viewModelScope.launch {
            _projects.postValue(db.projectDao().getByParts(dc, ble, wheel, rtc,
                    lcd, ul, led , air, mcu, acc,  hyd,  res))
        }
    }

}