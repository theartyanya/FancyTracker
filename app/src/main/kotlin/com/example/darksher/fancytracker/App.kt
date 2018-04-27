package com.example.darksher.fancytracker

import android.app.Application
import com.example.darksher.fancytracker.di.AppComponent
import com.example.darksher.fancytracker.di.AppModule
import com.example.darksher.fancytracker.di.DaggerAppComponent
import timber.log.Timber

class App : Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeInjector()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initializeInjector() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent.inject(this)
    }
}