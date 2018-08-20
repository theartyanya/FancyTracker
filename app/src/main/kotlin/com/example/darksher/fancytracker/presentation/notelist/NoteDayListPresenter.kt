package com.example.darksher.fancytracker.presentation.notelist

import com.arellomobile.mvp.InjectViewState
import com.example.darksher.fancytracker.Screens
import com.example.darksher.fancytracker.domain.*
import com.example.darksher.fancytracker.presentation.common.base.BasePresenter
import ru.terrakok.cicerone.Router

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
                NoteItemNotes(Note("Sun, 26", "Task 1", "Fancy description")),
                NoteItemNotes(Note("Sun, 26", "Task 2", "Fancy description")),
                NoteItemNotes(Note("Sun, 26", "Task 3", "Fancy description")),
                NoteItemNotes(Note("Sun, 26", "Task 4", "Fancy description")),
                NoteItemNotes(Note("Mon, 27", "Task 1", "Fancy description")),
                NoteItemNotes(Note("Mon, 27", "Task 2", "Fancy description")),
                NoteItemNotes(Note("Mon, 27", "Task 3", "Fancy description")),
                NoteItemNotes(Note("Mon, 27", "Task 4", "Fancy description")),
                NoteItemNotes(Note("Tue, 28", "Task 1", "Fancy description")),
                NoteItemNotes(Note("Tue, 28", "Task 2", "Fancy description")),
                NotesListItem(NotesListItem.Type.FOOTER),
                NoteItemNotes(Note("Tue, 28", "Task 3", "Fancy description", true)),
                NoteItemNotes(Note("Tue, 28", "Task 4", "Fancy description", true))

        )
    }
}