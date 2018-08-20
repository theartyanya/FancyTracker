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
import com.example.darksher.fancytracker.presentation.notelist.NoteDayListContract
import com.example.darksher.fancytracker.presentation.notelist.NoteDayListPresenter
import com.example.darksher.fancytracker.ui.adapter.NoteDayListAdapter
import kotlinx.android.synthetic.main.fragment_note_list.*

class DayNotesListFragment : BaseFragment<NoteDayListContract.Presenter>(), NoteDayListContract.View {

    @InjectPresenter lateinit var presenter: NoteDayListPresenter
    private var _adapter: NoteDayListAdapter? = null

    companion object {
        fun newInstance() = DayNotesListFragment()
    }

    @ProvidePresenter
    override fun providePresenter() = NoteDayListPresenter((activity as? RouterProvider)?.getRouter())

    override fun getPresenter(): NoteDayListContract.Presenter = presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _adapter = NoteDayListAdapter()
        _adapter?.setCallback { presenter.openNoteDetails() }
        _adapter?.setItemMoveCallback { fromPos, toPos -> presenter.moveItem(fromPos, toPos) }
        rv_notes.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        rv_notes.setHasFixedSize(true)
        rv_notes.layoutManager = LinearLayoutManager(context)
        rv_notes.adapter = _adapter
        fab.setOnClickListener { presenter.openAddNoteScreen() }
    }

    override fun showNotes(notes: List<NotesListItem>) {
        _adapter?.setItems(notes)
    }

    override fun onError(error: ErrorMessage) {
        super.handleError(error)
    }
}