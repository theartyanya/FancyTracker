package com.example.darksher.fancytracker.presentation.home

import com.arellomobile.mvp.InjectViewState
import com.example.darksher.fancytracker.Screens
import com.example.darksher.fancytracker.domain.*
import com.example.darksher.fancytracker.presentation.common.base.BasePresenter
import ru.terrakok.cicerone.Router
import java.util.*

@InjectViewState
class HomePresenter(private val router: Router?) : BasePresenter<HomeContract.View>(), HomeContract.Presenter {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState?.showNotesList(generateMockList())
    }

    override fun onBackPressed() {
        router?.exit()
    }

    override fun openNoteDetails() {
        router?.navigateTo(Screens.NOTE_DETAILS_SCREEN)
    }

    override fun openCreateNote() {
        router?.navigateTo(Screens.NOTE_CREATE_SCREEN)
    }

    override fun openMoreScreen() {
        router?.navigateTo(Screens.NOTE_DAY_LIST_SCREEN)
    }

    private fun generateMockList(): List<NotesListItem> {
        return listOf(
                HeaderItemNotes("Sun, 26"),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Sun, 26", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Sun, 26", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Sun, 26", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Sun, 26", listOf(Task("Hello", false)), false)),
                FooterItemNotes("Sun, 26"),
                HeaderItemNotes("Mon, 27"),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                FooterItemNotes("Mon, 27"),
                HeaderItemNotes("Tue, 28"),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Tue, 28", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Tue, 28", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Tue, 28", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Tue, 28", listOf(Task("Hello", false)), false)),
                FooterItemNotes("Tue, 28")
        )
    }
}