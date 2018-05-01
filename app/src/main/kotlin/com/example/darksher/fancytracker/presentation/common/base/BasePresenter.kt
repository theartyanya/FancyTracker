package com.example.darksher.fancytracker.presentation.common.base

import com.arellomobile.mvp.MvpPresenter
import com.example.darksher.fancytracker.presentation.common.error.ErrorMessage

abstract class BasePresenter<T : BaseContract.View> : MvpPresenter<T>(), BaseContract.Presenter {

    fun handleError(error: Throwable, defaultCode: ErrorMessage) {
        error.printStackTrace()
        viewState?.onError(defaultCode)
    }
}