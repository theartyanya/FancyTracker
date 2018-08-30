package com.example.darksher.fancytracker.di

import android.content.Context
import com.example.darksher.fancytracker.repository.NotesRepository
import com.example.darksher.fancytracker.repository.NotesRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [(NavigationModule::class)])
class AppModule(private val context: Context) {
    @Provides
    @Singleton
    fun provideNotesRepository(): NotesRepository = NotesRepositoryImpl()
}