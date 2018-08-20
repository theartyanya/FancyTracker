package com.example.darksher.fancytracker.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.darksher.fancytracker.R
import com.example.darksher.fancytracker.domain.FooterItemNotes
import com.example.darksher.fancytracker.domain.HeaderItemNotes
import com.example.darksher.fancytracker.domain.NotesListItem
import com.example.darksher.fancytracker.domain.NoteItemNotes
import kotlinx.android.synthetic.main.item_header.view.*
import kotlinx.android.synthetic.main.item_note.view.*

class NotesListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val _notes: MutableList<NotesListItem> = mutableListOf()
    private var _callback: (String) -> Unit = { }
    private var _moreCallback: (String) -> Unit = { }

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_NOTE = 1
        const val TYPE_FOOTER = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false))
            TYPE_FOOTER -> FooterHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_footer, parent, false))
            else -> NoteHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
        }
    }

    override fun getItemCount(): Int = _notes.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderHolder -> {
                val data = _notes[position] as HeaderItemNotes
                holder.tvTitle?.text = data.date
            }
            is NoteHolder -> {
                val data = _notes[position] as NoteItemNotes
                holder.tvTitle?.text = data.note.title
                holder.tvDescription?.text = data.note.description
                holder.itemView.setOnClickListener { _callback.invoke(data.note.title) }
            }
            is FooterHolder -> {
                val data = _notes[position] as FooterItemNotes
                holder.itemView.setOnClickListener {
                    _moreCallback.invoke(data.date)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int = when (_notes[position].type) {
        NotesListItem.Type.HEADER -> TYPE_HEADER
        NotesListItem.Type.NOTE -> TYPE_NOTE
        NotesListItem.Type.FOOTER -> TYPE_FOOTER
    }

    fun setItems(itemNotes: List<NotesListItem>) {
        _notes.clear()
        _notes.addAll(itemNotes)
        notifyDataSetChanged()
    }

    fun setCallback(callback: (String) -> Unit) {
        _callback = callback
    }

    fun setMoreCallback(callback: (String) -> Unit) {
        _moreCallback = callback
    }

    class HeaderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView? = itemView.tv_title
    }

    class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView? = itemView.note_title
        val tvDescription: TextView? = itemView.note_description
    }

    class FooterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
}