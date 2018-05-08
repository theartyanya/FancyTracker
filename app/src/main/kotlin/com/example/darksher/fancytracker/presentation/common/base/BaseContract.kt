package com.example.darksher.fancytracker.presentation.common.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.darksher.fancytracker.presentation.common.error.ErrorMessage

interface BaseContract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : MvpView {

        @StateStrategyType(SkipStrategy::class)
        fun onError(error: ErrorMessage)
    }

    interface Presenter {

        fun onBackPressed()
    }
}