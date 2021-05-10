package com.example.semesterproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProjectDao {
    @Insert
    suspend fun insertActor(project: Project)

    @Query("SELECT * FROM Project")
    suspend fun getAll(): List<Project>

    @Query("SELECT * FROM Project WHERE Difficulty >:year")
    suspend fun getYounger(year: Int): List<Project>

    @Query("SELECT * FROM Project WHERE Name LIKE :movie")
    suspend fun getByMovie(movie: String): List<Project>

    @Delete
    suspend fun deleteActor(actor: Project)





}