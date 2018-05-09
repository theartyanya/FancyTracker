package com.example.darksher.fancytracker.presentation.createnote

import com.arellomobile.mvp.InjectViewState
import com.example.darksher.fancytracker.presentation.common.base.BasePresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class CreateNotePresenter(private val router: Router?) :
        BasePresenter<CreateNoteContract.View>(), CreateNoteContract.Presenter {

    override fun onBackPressed() {
        router?.exit()
    }

}