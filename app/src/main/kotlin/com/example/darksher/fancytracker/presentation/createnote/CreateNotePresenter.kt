package com.example.darksher.fancytracker.presentation.createnote

import com.arellomobile.mvp.InjectViewState
import com.example.darksher.fancytracker.domain.interactor.AddNoteInteractor
import com.example.darksher.fancytracker.presentation.common.base.BasePresenter
import kotlinx.coroutines.experimental.launch
import ru.terrakok.cicerone.Router

@InjectViewState
class CreateNotePresenter(
        private val router: Router?,
        private val interactor: AddNoteInteractor
) : BasePresenter<CreateNoteContract.View>(), CreateNoteContract.Presenter {

    override suspend fun createNote(date: Long, title: String?, tasks: List<String>) {
        interactor.createNote(date, title, tasks).apply { onBackPressed() }
    }

    override fun onBackPressed() {
        router?.exit()
    }

}