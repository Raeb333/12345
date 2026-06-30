package com.example.data

import kotlinx.coroutines.flow.Flow

class VocationalRepository(private val dao: VocationalResultDao) {
    val allResults: Flow<List<VocationalResult>> = dao.getAllResults()

    suspend fun insert(result: VocationalResult) {
        dao.insertResult(result)
    }

    suspend fun delete(id: Int) {
        dao.deleteResultById(id)
    }
}
