package com.example.semesterproject

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Project(
        @PrimaryKey(autoGenerate = true) val projectId: Int,
        val Name: String,
        val Difficulty: Int,
        //val parts: Parts
        val MCU: Boolean,
        val Accelerometer: Boolean,
        val Hydro: Boolean,
        val Resistors: Boolean,
        val Bluetooth: Boolean
)
