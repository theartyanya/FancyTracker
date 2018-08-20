package com.example.darksher.fancytracker.domain

open class NotesListItem(
        val type: Type
) {
    enum class Type {
        HEADER,
        NOTE,
        FOOTER
    }
}