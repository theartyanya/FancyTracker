package com.example.darksher.fancytracker.repository

import com.example.darksher.fancytracker.domain.Note
import com.example.darksher.fancytracker.domain.Task
import io.realm.Realm
import kotlinx.coroutines.experimental.async
import javax.inject.Singleton

@Singleton
class NotesRepositoryImpl : NotesRepository {
    override suspend fun createNote(date: Long, title: String?, tasks: List<String>): Boolean {
        return async {
            val realm = Realm.getDefaultInstance()
            realm.executeTransaction {
                it.insertOrUpdate(
                        Note(
                                date = date,
                                title = title,
                                tasks = tasks.map { Task(it, false) },
                                isDone = false
                                )
                )
            }
            realm.close()
            true
        }.await()
    }
}