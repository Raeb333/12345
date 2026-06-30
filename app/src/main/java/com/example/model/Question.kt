package com.example.model

data class Question(
    val id: Int,
    val text: String,
    val dimension: String // "R", "I", "A", "S", "E", "C"
)
