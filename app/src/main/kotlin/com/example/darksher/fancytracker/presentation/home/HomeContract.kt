package com.example.darksher.fancytracker.presentation.home

import com.example.darksher.fancytracker.domain.NotesListItem
import com.example.darksher.fancytracker.presentation.common.base.BaseContract

interface HomeContract {

    interface View : BaseContract.View {
        fun showNotesList(notes: List<NotesListItem>)
    }

    interface Presenter : BaseContract.Presenter {
        fun openNoteDetails()
        fun openCreateNote()
    }
}