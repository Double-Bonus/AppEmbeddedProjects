package com.example.semesterproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.semesterproject.daos.ProjectDao
import com.example.semesterproject.models.Project

@Database(entities = arrayOf(Project::class), version = 2)
abstract class ProjectDatabase : RoomDatabase(){
    abstract fun projectDao(): ProjectDao

    companion object {
        @Volatile
        private var _instance: ProjectDatabase? = null
        fun getInstance(context: Context) : ProjectDatabase {
            return _instance ?: synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProjectDatabase::class.java,
                        "projects-db"
                ).createFromAsset("new-project.db")
                        .build()
                _instance = instance
                instance
            }
        }
    }
}

