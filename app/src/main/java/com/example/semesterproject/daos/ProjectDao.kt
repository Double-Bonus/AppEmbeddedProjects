package com.example.semesterproject.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.semesterproject.models.Project

@Dao
interface ProjectDao {
    @Insert
    suspend fun insertAll(vararg project: Project)

    @Query("SELECT * FROM projects")
    suspend fun getAll(): List<Project>

    @Query("SELECT * FROM projects WHERE Difficulty >:diff")
    suspend fun getEasier(diff: Int): List<Project>

    @Query("SELECT * FROM projects WHERE Name LIKE :name")
    suspend fun getByName(name: String): List<Project>


    @Query("SELECT * FROM projects WHERE ((not(DC_motor) OR :dc ) AND (not(BLE) OR :ble) AND (not(Wheels) OR :wheel) AND (not(RTC) OR :rtc) AND (not(LCD) OR :lcd) AND (not(Ultrasonic) OR :ul) AND (not(LED) OR :led) AND (not(Air_quality) OR :air) AND (not(MCU) OR :mcu) AND (not(Accelerometer) OR :acc) AND (not(Hydro) OR :hyd) AND (not(Resistors) OR :res)) ")
    suspend fun getByParts(dc: Boolean, ble : Boolean, wheel :Boolean, rtc : Boolean,
                           lcd : Boolean, ul : Boolean, led : Boolean, air : Boolean,
                           mcu : Boolean, acc : Boolean,  hyd : Boolean,  res : Boolean): List<Project>

    @Delete
    suspend fun deleteProject(project: Project)


}