package com.example.darksher.fancytracker.presentation.notelist

import com.arellomobile.mvp.InjectViewState
import com.example.darksher.fancytracker.Screens
import com.example.darksher.fancytracker.domain.*
import com.example.darksher.fancytracker.presentation.common.base.BasePresenter
import ru.terrakok.cicerone.Router
import java.util.*

@InjectViewState
class NoteDayListPresenter(private val router: Router?) :
        BasePresenter<NoteDayListContract.View>(), NoteDayListContract.Presenter {

    private val _items: MutableList<NotesListItem> = mutableListOf()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        _items.addAll(generateMockList())
        viewState?.showNotes(_items)
    }

    override fun moveItem(fromPos: Int, toPos: Int) {
        val item = _items[fromPos] as NoteItemNotes
        _items.removeAt(fromPos)
        _items.add(toPos, item)
    }

    override fun openNoteDetails() {
        router?.navigateTo(Screens.NOTE_DETAILS_SCREEN)
    }

    override fun openAddNoteScreen() {
        router?.navigateTo(Screens.NOTE_CREATE_SCREEN)
    }

    override fun onBackPressed() {
        router?.exit()
    }

    private fun generateMockList(): List<NotesListItem> {
        return listOf(
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NotesListItem(NotesListItem.Type.FOOTER),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false)),
                NoteItemNotes(Note(Calendar.getInstance().timeInMillis, "Mon, 27", listOf(Task("Hello", false)), false))

        )
    }
}