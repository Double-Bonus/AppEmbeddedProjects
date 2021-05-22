package com.example.semesterproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.semesterproject.database.SensorDatabase
import java.lang.IllegalArgumentException

class SensorsViewModelFactory (private val db: SensorDatabase) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SensorsViewModel::class.java)){
            return SensorsViewModel(db) as T
        }
        throw IllegalArgumentException()
    }
}