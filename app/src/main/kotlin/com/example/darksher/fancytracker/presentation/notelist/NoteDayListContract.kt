package com.example.darksher.fancytracker.presentation.notelist

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.darksher.fancytracker.domain.NotesListItem
import com.example.darksher.fancytracker.presentation.common.base.BaseContract

interface NoteDayListContract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : BaseContract.View {
        fun showNotes(notes: List<NotesListItem>)
    }

    interface Presenter : BaseContract.Presenter {
        fun openNoteDetails()
        fun openAddNoteScreen()
        fun moveItem(fromPos: Int, toPos: Int)
    }
}