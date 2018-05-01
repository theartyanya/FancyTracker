package com.example.darksher.fancytracker.presentation.main

import com.example.darksher.fancytracker.Screens
import com.example.darksher.fancytracker.presentation.common.base.BasePresenter
import ru.terrakok.cicerone.Router

class MainPresenter(private val router: Router?) : BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router?.newRootScreen(Screens.HOME_SCREEN)
    }

    override fun onBackPressed() {
        router?.exit()
    }
}