package com.example.semesterproject.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.semesterproject.daos.ProjectDao
import com.example.semesterproject.models.Project

@Database(entities = arrayOf(Project::class), version = 1)
abstract class ProjectDatabase : RoomDatabase(){
    abstract fun projectDao(): ProjectDao
}