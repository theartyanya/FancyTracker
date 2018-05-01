package com.example.darksher.fancytracker.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.darksher.fancytracker.R
import com.example.darksher.fancytracker.navigation.RouterProvider
import com.example.darksher.fancytracker.presentation.common.base.BaseFragment
import com.example.darksher.fancytracker.presentation.common.error.ErrorMessage

class HomeFragment : BaseFragment<HomeContract.Presenter>(), HomeContract.View {

    @InjectPresenter lateinit var presenter: HomePresenter

    companion object {

        fun newInstance() = HomeFragment()
    }

    @ProvidePresenter
    override fun providePresenter() = HomePresenter((activity as? RouterProvider)?.getRouter())

    override fun getPresenter(): HomeContract.Presenter = presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onError(error: ErrorMessage) {
        super.handleError(error)
    }

}