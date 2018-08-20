package com.example.darksher.fancytracker.navigation

import android.support.v4.app.Fragment
import com.example.darksher.fancytracker.Screens
import com.example.darksher.fancytracker.ui.*

object FragmentsFactory {

    fun create(screenKey: String?, data: Any?): Fragment? {
        return when(screenKey) {
            Screens.HOME_SCREEN -> HomeFragment.newInstance()
            Screens.NOTE_DETAILS_SCREEN -> NoteDetailsFragment.newInstance()
            Screens.NOTE_CREATE_SCREEN -> CreateNoteFragment.newInstance()
            Screens.NOTE_DAY_LIST_SCREEN -> DayNotesListFragment.newInstance()
            else -> null
        }
    }
}