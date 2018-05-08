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
import com.example.darksher.fancytracker.presentation.notedetails.NoteDetailsContract
import com.example.darksher.fancytracker.presentation.notedetails.NoteDetailsPresenter

class NoteDetailsFragment : BaseFragment<NoteDetailsContract.Presenter>(), NoteDetailsContract.View {

    @InjectPresenter lateinit var presenter: NoteDetailsPresenter

    companion object {
        fun newInstance() = NoteDetailsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    @ProvidePresenter
    override fun providePresenter() = NoteDetailsPresenter((parentFragment as? RouterProvider)?.getRouter())

    override fun getPresenter(): NoteDetailsContract.Presenter = presenter

    override fun onError(error: ErrorMessage) {
        super.handleError(error)
    }
}