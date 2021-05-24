package com.example.semesterproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semesterproject.database.SensorDatabase
import com.example.semesterproject.models.Sensor
import com.example.semesterproject.utils.MockData
import kotlinx.coroutines.launch

class SensorsViewModel (private val db: SensorDatabase) : ViewModel() {

    private val _sensors = MutableLiveData<List<Sensor>>()
    val sensors: LiveData<List<Sensor>>
        get() = _sensors

    init {
        getSensors()
    }


    //TODO proble will need only in future!
    fun addSensor(){
        viewModelScope.launch {
            db.sensorDao().insertAll(MockData.getRandomSensor())
            getSensors()
        }
    }

    private fun getSensors() {
        viewModelScope.launch {
            _sensors.postValue(db.sensorDao().getAllSensors())
        }
    }


}