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

    @Delete
    suspend fun deleteProject(project: Project)


}