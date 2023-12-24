package com.example.WorkersDataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.WorkersDataBase.Worker.Worker
import kotlinx.coroutines.flow.Flow

@Dao
interface RabotnikDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRabotnik (worker: Worker)
    @Delete
    suspend fun deleteRabotnik (worker: Worker)
    @Query("SELECT * FROM rabotnik")
    fun getAllRabotniks(): Flow<List<Worker>>

}