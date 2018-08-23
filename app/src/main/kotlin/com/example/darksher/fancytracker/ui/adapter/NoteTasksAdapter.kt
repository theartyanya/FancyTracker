package com.example.darksher.fancytracker.ui.adapter

import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import com.example.darksher.fancytracker.R
import kotlinx.android.synthetic.main.item_task_field.view.*

class NoteTasksAdapter : RecyclerView.Adapter<NoteTasksAdapter.TaskHolder>() {

    private val _tasks: MutableList<String> = mutableListOf("")
    private var _focused = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        return TaskHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task_field, parent, false))
    }

    override fun getItemCount(): Int = _tasks.size

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.field.setHorizontallyScrolling(false)
        holder.field.maxLines = 3
        holder.field.setText(_tasks[position])
        if (_focused == position) {
            holder.field.requestFocus()
            holder.field.performClick()
            holder.field.setSelection(holder.field.text.length)
        }
        holder.field.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                if (v.text.isNotEmpty()) {
                    _tasks.add("")
                    _focused = holder.adapterPosition + 1
                    notifyItemRangeChanged(holder.adapterPosition + 1, itemCount)
                }
                true
            } else
                false
        }

        holder.field.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && itemCount != 1 && (v as EditText).text.isEmpty()) {
                if (holder.adapterPosition == 0) {
                    _tasks.removeAt(holder.adapterPosition)
                    _focused = holder.adapterPosition
                    notifyItemRemoved(holder.adapterPosition)
                    notifyItemRangeChanged(holder.adapterPosition, itemCount + 1)
                } else {
                    _tasks.removeAt(holder.adapterPosition)
                    _focused = holder.adapterPosition - 1
                    notifyItemRemoved(holder.adapterPosition)
                    notifyItemRangeChanged(holder.adapterPosition - 1, itemCount - holder.adapterPosition + 1)
                }
                true
            } else
                false
        }

        holder.field.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                _tasks[holder.adapterPosition] = s.toString()
            }

        })

    }

    class TaskHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val field: EditText = itemView.et_task
    }
}