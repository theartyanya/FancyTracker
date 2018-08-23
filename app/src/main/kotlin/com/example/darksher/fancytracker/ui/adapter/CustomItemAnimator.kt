package com.example.darksher.fancytracker.ui.adapter

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView

class CustomItemAnimator : DefaultItemAnimator() {
    override fun animateChange(oldHolder: RecyclerView.ViewHolder?, newHolder: RecyclerView.ViewHolder?, fromX: Int, fromY: Int, toX: Int, toY: Int): Boolean {
        if (oldHolder == newHolder) {
            if (oldHolder != null) {
                dispatchChangeFinished(oldHolder,true)
            }
        } else {
            if (oldHolder != null) {
                dispatchChangeFinished(oldHolder, true)
            }
            if (newHolder != null) {
                dispatchChangeFinished(newHolder, false)
            }
        }
        return false
    }
}