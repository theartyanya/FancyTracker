package com.example.darksher.fancytracker.ui

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.darksher.fancytracker.R
import com.example.darksher.fancytracker.domain.NotesListItem
import com.example.darksher.fancytracker.navigation.RouterProvider
import com.example.darksher.fancytracker.presentation.common.base.BaseFragment
import com.example.darksher.fancytracker.presentation.common.error.ErrorMessage
import com.example.darksher.fancytracker.presentation.home.HomeContract
import com.example.darksher.fancytracker.presentation.home.HomePresenter
import com.example.darksher.fancytracker.ui.adapter.NotesListAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<HomeContract.Presenter>(), HomeContract.View {

    @InjectPresenter lateinit var presenter: HomePresenter
    private var _adapter: NotesListAdapter? = null

    companion object {

        fun newInstance() = HomeFragment()
    }

    @ProvidePresenter
    override fun providePresenter() = HomePresenter((activity as? RouterProvider)?.getRouter())

    override fun getPresenter(): HomeContract.Presenter = presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        _adapter = NotesListAdapter()
        _adapter?.setCallback { presenter.openNoteDetails() }
        _adapter?.setMoreCallback { presenter.openMoreScreen() }
        rv_notes?.adapter = _adapter
        rv_notes?.setHasFixedSize(true)
        rv_notes?.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        rv_notes?.layoutManager = LinearLayoutManager(context)

        fab.setOnClickListener { presenter.openCreateNote() }
    }

    override fun showNotesList(notes: List<NotesListItem>) {
        _adapter?.setItems(notes)
    }

    override fun onError(error: ErrorMessage) {
        super.handleError(error)
    }

}