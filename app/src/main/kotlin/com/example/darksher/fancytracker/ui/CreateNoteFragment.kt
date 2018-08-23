package com.example.darksher.fancytracker.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
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
import com.example.darksher.fancytracker.ui.adapter.CustomItemAnimator
import com.example.darksher.fancytracker.ui.adapter.NoteTasksAdapter
import kotlinx.android.synthetic.main.fragment_create.*

class CreateNoteFragment : BaseFragment<CreateNoteContract.Presenter>(), CreateNoteContract.View {

    @InjectPresenter lateinit var presenter: CreateNotePresenter
    private var _adapter: NoteTasksAdapter? = null

    companion object {
        fun newInstance() = CreateNoteFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_create, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_back.setOnClickListener { presenter.onBackPressed() }

        _adapter = NoteTasksAdapter()
        rv_subtasks.layoutManager = LinearLayoutManager(context)
        rv_subtasks.adapter = _adapter
        rv_subtasks.itemAnimator = CustomItemAnimator()
    }

    @ProvidePresenter
    override fun providePresenter() = CreateNotePresenter((activity as? RouterProvider)?.getRouter())

    override fun getPresenter(): CreateNoteContract.Presenter = presenter

    override fun onError(error: ErrorMessage) {
        super.handleError(error)
    }
}