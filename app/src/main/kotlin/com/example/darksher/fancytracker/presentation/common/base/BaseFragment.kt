package com.example.darksher.fancytracker.presentation.common.base

import android.support.annotation.StringRes
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.darksher.fancytracker.navigation.RouterProvider
import com.example.darksher.fancytracker.presentation.common.error.ErrorMessage
import ru.terrakok.cicerone.Router

abstract class BaseFragment<out P: BaseContract.Presenter> : MvpAppCompatFragment(), RouterProvider {

    @ProvidePresenter
    abstract fun providePresenter(): P

    abstract fun getPresenter(): P

    override fun getRouter(): Router = (activity as RouterProvider).getRouter()

    protected fun showToast(@StringRes stringRes: Int) {
        (activity as? BaseActivity<*>)?.showToast(stringRes)
    }

    protected fun showToast(message: String) {
        (activity as? BaseActivity<*>)?.showToast(message)
    }

    protected fun handleError(errorCode: ErrorMessage) {
        (activity as? BaseActivity<*>)?.handleError(errorCode)
    }

    fun onBackButtonPressed(): Boolean {
        getPresenter().onBackPressed()
        return true
    }
}