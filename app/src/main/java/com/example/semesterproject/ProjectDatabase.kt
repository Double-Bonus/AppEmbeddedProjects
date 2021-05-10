package com.example.semesterproject

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Project::class), version = 1)
abstract class ProjectDatabase : RoomDatabase(){
    abstract fun projectDao(): ProjectDao
}