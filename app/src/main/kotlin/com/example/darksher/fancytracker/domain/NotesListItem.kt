package com.example.darksher.fancytracker.domain

abstract class NotesListItem(
        val type: Type
) {
    enum class Type {
        HEADER,
        NOTE,
        FOOTER
    }
}