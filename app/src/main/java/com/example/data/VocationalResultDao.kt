package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface VocationalResultDao {
    @Query("SELECT * FROM vocational_results ORDER BY timestamp DESC")
    fun getAllResults(): Flow<List<VocationalResult>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(result: VocationalResult)

    @Query("DELETE FROM vocational_results WHERE id = :id")
    suspend fun deleteResultById(id: Int)
}
