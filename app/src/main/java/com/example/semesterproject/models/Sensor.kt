package com.example.semesterproject.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sensors")
data class Sensor(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val imageUrl: String,
    val name: String,
    val desc: String,
    val price: Int
)
