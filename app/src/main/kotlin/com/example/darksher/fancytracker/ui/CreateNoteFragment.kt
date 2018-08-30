package com.example.darksher.fancytracker.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.darksher.fancytracker.App
import com.example.darksher.fancytracker.R
import com.example.darksher.fancytracker.domain.interactor.AddNoteInteractor
import com.example.darksher.fancytracker.navigation.RouterProvider
import com.example.darksher.fancytracker.presentation.common.base.BaseFragment
import com.example.darksher.fancytracker.presentation.common.error.ErrorMessage
import com.example.darksher.fancytracker.presentation.createnote.CreateNoteContract
import com.example.darksher.fancytracker.presentation.createnote.CreateNotePresenter
import com.example.darksher.fancytracker.ui.adapter.CustomItemAnimator
import com.example.darksher.fancytracker.ui.adapter.NoteTasksAdapter
import kotlinx.android.synthetic.main.fragment_create.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import java.util.*
import javax.inject.Inject

class CreateNoteFragment : BaseFragment<CreateNoteContract.Presenter>(), CreateNoteContract.View, DatePickerDialog.OnDateSetListener {

    @InjectPresenter lateinit var presenter: CreateNotePresenter
    @Inject lateinit var interactor: AddNoteInteractor
    private lateinit var _adapter: NoteTasksAdapter
    private val calendar = Calendar.getInstance()

    companion object {
        fun newInstance() = CreateNoteFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
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

        et_date.setText(DateUtils.formatDateTime(context, calendar.timeInMillis, DateUtils.FORMAT_SHOW_DATE))
        et_date.setOnClickListener {
            DatePickerDialog(context, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        btn_add_note.setOnClickListener {
            launch(UI) {
                presenter.createNote(calendar.timeInMillis, et_title.text.toString(), _adapter.getTasks())
            }
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        calendar.set(year, month, dayOfMonth)
        et_date.setText(DateUtils.formatDateTime(context, calendar.timeInMillis, DateUtils.FORMAT_SHOW_DATE))
    }

    @ProvidePresenter
    override fun providePresenter() = CreateNotePresenter((activity as? RouterProvider)?.getRouter(), interactor)

    override fun getPresenter(): CreateNoteContract.Presenter = presenter

    override fun onError(error: ErrorMessage) {
        super.handleError(error)
    }
}