package com.example.darksher.fancytracker.ui

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
import com.example.darksher.fancytracker.presentation.createnote.CreateNoteContract
import com.example.darksher.fancytracker.presentation.createnote.CreateNotePresenter

class CreateNoteFragment : BaseFragment<CreateNoteContract.Presenter>(), CreateNoteContract.View {

    @InjectPresenter lateinit var presenter: CreateNotePresenter

    companion object {
        fun newInstance() = CreateNoteFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_create, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    @ProvidePresenter
    override fun providePresenter() = CreateNotePresenter((parentFragment as? RouterProvider)?.getRouter())

    override fun getPresenter(): CreateNoteContract.Presenter = presenter

    override fun onError(error: ErrorMessage) {
        super.handleError(error)
    }
}