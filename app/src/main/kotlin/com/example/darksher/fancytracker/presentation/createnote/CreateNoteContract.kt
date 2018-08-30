package com.example.darksher.fancytracker.presentation.createnote

import com.example.darksher.fancytracker.presentation.common.base.BaseContract

interface CreateNoteContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter {
        suspend fun createNote(date: Long, title: String?, tasks: List<String>)
    }
}