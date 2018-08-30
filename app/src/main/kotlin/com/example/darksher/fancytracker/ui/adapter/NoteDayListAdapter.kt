package com.example.darksher.fancytracker.ui.adapter

import android.support.v7.widget.RecyclerView
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.example.darksher.fancytracker.R
import com.example.darksher.fancytracker.domain.NoteItemNotes
import com.example.darksher.fancytracker.domain.NotesListItem
import kotlinx.android.synthetic.main.item_note_with_checkbox.view.*

class NoteDayListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val _notes: MutableList<NotesListItem> = mutableListOf()
    private var _callback: (String) -> Unit = { }
    private var _itemMoveCallback: (fromPos: Int, toPos: Int) -> Unit = { fromPos, toPos -> { } }
    private var _dividerPos = 0

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_DIVIDER = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_DIVIDER -> DividerHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_divider, parent, false))
            else -> NoteHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note_with_checkbox, parent, false))
        }
    }

    override fun getItemCount(): Int = _notes.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NoteHolder -> {
                val data = _notes[position] as NoteItemNotes
                val strikeSpan = StrikethroughSpan()
                val span = SpannableString(data.note.title)
                holder.tvTitle?.text = data.note.title
                holder.tvDescription?.text = data.note.tasks.first()?.text
                holder.itemView.setOnClickListener { _callback.invoke(data.note.title ?: "") }
                /*if (data.note.isDone) {
                    holder.checkBox?.isChecked = true
                    val span = SpannableString(holder.tvTitle?.text)
                    span.setSpan(StrikethroughSpan(), 0, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    holder.tvTitle?.text = span
                } else {

                }*/
                holder.checkBox?.setOnCheckedChangeListener(null)
                if (data.note.isDone) {
                    holder.checkBox?.isChecked = true
                    span.setSpan(strikeSpan, 0, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    holder.tvTitle?.text = span
                }
                holder.checkBox?.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        span.setSpan(strikeSpan, 0, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                        holder.tvTitle?.text = span
                        holder.moveDown()
                    } else {
                        span.removeSpan(strikeSpan)
                        holder.tvTitle?.text = span
                        holder.moveUp()
                    }
                }
            }
            is DividerHolder -> {
            }
        }
    }

    override fun getItemViewType(position: Int): Int = when (_notes[position].type) {
        NotesListItem.Type.HEADER -> TYPE_HEADER
        NotesListItem.Type.FOOTER -> {
            _dividerPos = position
            TYPE_DIVIDER
        }
        else -> -1
    }

    fun setItems(itemNotes: List<NotesListItem>) {
        _notes.clear()
        _notes.addAll(itemNotes)
        notifyDataSetChanged()
    }

    fun setCallback(callback: (String) -> Unit) {
        _callback = callback
    }

    fun setItemMoveCallback(callback: (fromPos: Int, toPos: Int) -> Unit) {
        _itemMoveCallback = callback
    }

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView? = itemView.note_title
        val tvDescription: TextView? = itemView.note_description
        val checkBox: CheckBox? = itemView.checkBox

        fun moveUp() {
            layoutPosition.takeIf { it > 0 }?.also { currentPosition ->
                _notes.removeAt(currentPosition).also {
                    _notes.add(_dividerPos, it.apply { (it as NoteItemNotes).note.isDone = false })
                }.also { _itemMoveCallback(currentPosition, _dividerPos) }
                notifyItemMoved(currentPosition, _dividerPos)
                notifyItemChanged(currentPosition)
            }
        }

        fun moveDown() {
            layoutPosition.takeIf { it < _notes.size - 1 }?.also { currentPosition ->
                _notes.removeAt(currentPosition).also {
                    _notes.add(_dividerPos, it.apply { (it as NoteItemNotes).note.isDone = true })
                }.also { _itemMoveCallback(currentPosition, _dividerPos) }
                notifyItemMoved(currentPosition, _dividerPos)
                notifyItemChanged(currentPosition)
            }
        }
    }

    class DividerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
}