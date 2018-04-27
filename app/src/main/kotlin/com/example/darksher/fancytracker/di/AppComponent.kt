package com.example.darksher.fancytracker.di

import com.example.darksher.fancytracker.App
import com.example.darksher.fancytracker.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun inject(app: App)
    fun inject(activity: MainActivity)
}