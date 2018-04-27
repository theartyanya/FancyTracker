package com.example.darksher.fancytracker.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.darksher.fancytracker.App
import com.example.darksher.fancytracker.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)
    }
}
