package com.example.darksher.fancytracker.domain

data class HeaderItemNotes(
        val date: String
) : NotesListItem(Type.HEADER)