package com.example.darksher.fancytracker.di

import android.content.Context
import dagger.Module

@Module(includes = [(NavigationModule::class)])
class AppModule(private val context: Context) {
}