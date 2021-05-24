package com.example.semesterproject.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "projects")
data class Project(
        @PrimaryKey(autoGenerate = true) val projectId: Int,
        val Name: String,
        val Difficulty: Int,
        //val parts: Parts // TODO embeded classs
        val DC_motor: Boolean,
        val BLE: Boolean,
        val Wheels: Boolean,
        val RTC: Boolean,
        val LCD: Boolean,
        val Ultrasonic: Boolean,
        val LED: Boolean,
        val Air_quality: Boolean,
        val MCU: Boolean,
        val Accelerometer: Boolean,
        val Hydro: Boolean,
        val Resistors: Boolean,
        val Bluetooth: Boolean

        //val imageUrl: String,
)
