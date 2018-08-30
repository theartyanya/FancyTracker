package com.example.darksher.fancytracker.repository

interface NotesRepository {
    suspend fun createNote(date: Long, title: String?, tasks: List<String>): Boolean
}