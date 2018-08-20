package com.example.darksher.fancytracker.domain

data class Note(
        val date: String,
        val title: String,
        val description: String,
        var isDone: Boolean = false
)