package com.example.darksher.fancytracker.presentation.home

import com.arellomobile.mvp.InjectViewState
import com.example.darksher.fancytracker.domain.*
import com.example.darksher.fancytracker.presentation.common.base.BasePresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class HomePresenter(private val router: Router?) : BasePresenter<HomeContract.View>(), HomeContract.Presenter {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState?.showNotesList(generateMockList())
    }

    override fun onBackPressed() {
        router?.exit()
    }

    private fun generateMockList(): List<NotesListItem> {
        return listOf(
                HeaderItemNotes("Sun, 26"),
                NoteItemNotes(Note("Sun, 26", "Task 1", "Fancy description")),
                NoteItemNotes(Note("Sun, 26", "Task 2", "Fancy description")),
                NoteItemNotes(Note("Sun, 26", "Task 3", "Fancy description")),
                NoteItemNotes(Note("Sun, 26", "Task 4", "Fancy description")),
                FooterItemNotes("Sun, 26"),
                HeaderItemNotes("Mon, 27"),
                NoteItemNotes(Note("Mon, 27", "Task 1", "Fancy description")),
                NoteItemNotes(Note("Mon, 27", "Task 2", "Fancy description")),
                NoteItemNotes(Note("Mon, 27", "Task 3", "Fancy description")),
                NoteItemNotes(Note("Mon, 27", "Task 4", "Fancy description")),
                FooterItemNotes("Mon, 27"),
                HeaderItemNotes("Tue, 28"),
                NoteItemNotes(Note("Tue, 28", "Task 1", "Fancy description")),
                NoteItemNotes(Note("Tue, 28", "Task 2", "Fancy description")),
                NoteItemNotes(Note("Tue, 28", "Task 3", "Fancy description")),
                NoteItemNotes(Note("Tue, 28", "Task 4", "Fancy description")),
                FooterItemNotes("Tue, 28")
        )
    }
}