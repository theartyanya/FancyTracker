package com.example.darksher.fancytracker.presentation.common.base

import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.darksher.fancytracker.presentation.common.error.ErrorMesageFactory
import com.example.darksher.fancytracker.presentation.common.error.ErrorMessage

abstract class BaseActivity<out P: BaseContract.Presenter> : MvpAppCompatActivity() {

    abstract fun providePresenter(): P

    fun addFragment(containerViewId: Int, fragment: Fragment) {
        val fragmentTransaction = this.supportFragmentManager.beginTransaction()
        fragmentTransaction.add(containerViewId, fragment)
        fragmentTransaction.commit()
    }

    fun showToast(@StringRes stringRes: Int) {
        Toast.makeText(this, stringRes, Toast.LENGTH_SHORT).show()
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun handleError(errorCode: ErrorMessage) {
        showToast(ErrorMesageFactory.create(this, errorCode))
    }
}