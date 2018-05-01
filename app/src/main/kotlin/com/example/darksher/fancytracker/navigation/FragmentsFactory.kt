package com.example.darksher.fancytracker.navigation

import android.support.v4.app.Fragment

object FragmentsFactory {

    fun create(screenKey: String?, data: Any?): Fragment? {
        return when(screenKey) {
            else -> null
        }
    }
}