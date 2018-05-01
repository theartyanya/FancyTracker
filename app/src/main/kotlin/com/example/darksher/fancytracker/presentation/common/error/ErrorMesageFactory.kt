package com.example.darksher.fancytracker.presentation.common.error

import android.content.Context
import com.example.darksher.fancytracker.R
import com.example.darksher.fancytracker.presentation.common.error.ErrorMessage.*

object ErrorMesageFactory {

    fun create(context: Context, errorCode: ErrorMessage): String {
        return context.getString(
                when (errorCode) {
                    ERROR_GENERIC -> R.string.error_generic
                }
        )
    }
}