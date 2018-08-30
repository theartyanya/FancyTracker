package com.example.darksher.fancytracker.domain.interactor

import com.example.darksher.fancytracker.repository.NotesRepository
import javax.inject.Inject

class AddNoteInteractor @Inject constructor(private val repository: NotesRepository) {
    suspend fun createNote(date: Long, title: String?, tasks: List<String>): Boolean {
        return repository.createNote(date, title, tasks)
    }
}