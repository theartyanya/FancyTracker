package com.example.darksher.fancytracker.presentation.common.base

import com.arellomobile.mvp.MvpView
import com.example.darksher.fancytracker.presentation.common.error.ErrorMessage

interface BaseContract {

    interface View : MvpView {

        fun onError(error: ErrorMessage)
    }

    interface Presenter {

        fun onBackPressed()
    }
}