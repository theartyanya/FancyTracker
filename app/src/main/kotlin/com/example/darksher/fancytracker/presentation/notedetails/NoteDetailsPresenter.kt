package com.example.darksher.fancytracker.presentation.notedetails

import com.arellomobile.mvp.InjectViewState
import com.example.darksher.fancytracker.presentation.common.base.BasePresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class NoteDetailsPresenter(private val router: Router?) :
        BasePresenter<NoteDetailsContract.View>(), NoteDetailsContract.Presenter {

    override fun onBackPressed() {
        router?.exit()
    }
}