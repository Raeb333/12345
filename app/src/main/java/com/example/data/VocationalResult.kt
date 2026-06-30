package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vocational_results")
data class VocationalResult(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userName: String,
    val timestamp: Long = System.currentTimeMillis(),
    val rScore: Int,
    val iScore: Int,
    val aScore: Int,
    val sScore: Int,
    val eScore: Int,
    val cScore: Int,
    val topThree: String
)
