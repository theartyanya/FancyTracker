package com.example.darksher.fancytracker.navigation

import android.support.v4.app.Fragment
import com.example.darksher.fancytracker.Screens
import com.example.darksher.fancytracker.ui.HomeFragment
import com.example.darksher.fancytracker.ui.NoteDetailsFragment

object FragmentsFactory {

    fun create(screenKey: String?, data: Any?): Fragment? {
        return when(screenKey) {
            Screens.HOME_SCREEN -> HomeFragment.newInstance()
            Screens.NOTE_DETAILS_SCREEN -> NoteDetailsFragment.newInstance()
            else -> null
        }
    }
}