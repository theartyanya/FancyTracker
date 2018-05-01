package com.example.darksher.fancytracker.presentation.main

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.darksher.fancytracker.presentation.common.base.BaseContract

interface MainContract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter
}