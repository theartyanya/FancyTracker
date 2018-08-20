package com.example.darksher.fancytracker.presentation.main

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.darksher.fancytracker.App
import com.example.darksher.fancytracker.R
import com.example.darksher.fancytracker.navigation.NavigatorFactory
import com.example.darksher.fancytracker.navigation.RouterProvider
import com.example.darksher.fancytracker.presentation.common.base.BaseActivity
import com.example.darksher.fancytracker.presentation.common.error.ErrorMessage
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainActivity : BaseActivity<MainContract.Presenter>(), RouterProvider, MainContract.View {

    @Inject lateinit var cicerone: Cicerone<Router >
    @Inject lateinit var localRouter: Router
    @InjectPresenter lateinit var presenter: MainPresenter

    @ProvidePresenter
    override fun providePresenter() = MainPresenter(localRouter)

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getRouter(): Router = localRouter

    private val _navigator: Navigator by lazy {
        NavigatorFactory.create(supportFragmentManager, this, R.id.fl_container)
    }

    override fun onError(error: ErrorMessage) = super.handleError(error)

    override fun onResumeFragments() {
        super.onResumeFragments()
        cicerone.navigatorHolder.setNavigator(_navigator)
    }

    override fun onPause() {
        super.onPause()
        cicerone.navigatorHolder.removeNavigator()
    }
}
