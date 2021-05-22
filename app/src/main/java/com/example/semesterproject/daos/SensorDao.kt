package com.example.semesterproject.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.semesterproject.models.Sensor

@Dao
interface SensorDao{

    @Query("SELECT * FROM sensors")
    suspend fun getAllSensors(): List<Sensor>

    @Insert
    suspend fun insertAll(vararg sensor: Sensor)


}