package com.example.darksher.fancytracker.presentation.home

import com.example.darksher.fancytracker.presentation.common.base.BasePresenter
import ru.terrakok.cicerone.Router

class HomePresenter(private val router: Router?) : BasePresenter<HomeContract.View>(), HomeContract.Presenter {
    override fun onBackPressed() {
        router?.exit()
    }
}