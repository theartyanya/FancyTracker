package com.example.darksher.fancytracker.presentation.home

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.darksher.fancytracker.presentation.common.base.BaseContract

@StateStrategyType(AddToEndSingleStrategy::class)
interface HomeContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter
}