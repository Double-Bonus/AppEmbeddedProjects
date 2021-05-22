package com.example.semesterproject.database

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.semesterproject.daos.SensorDao
import com.example.semesterproject.models.Sensor

@Database(entities = arrayOf(Sensor::class), version = 1)
abstract class SensorDatabase : RoomDatabase(){
    abstract fun sensorDao(): SensorDao

    companion object {
        @Volatile
        private var _instance: SensorDatabase? = null
        fun getInstance(context: Context) : SensorDatabase {
            return _instance ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SensorDatabase::class.java,
                    "sensor-db"
                ).build()
                _instance = instance
                instance
            }
        }
    }





}