package com.example.semesterproject.models

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sensors")
data class Sensor(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @DrawableRes val image: Int,
    val name: String,
    val desc: String
)
