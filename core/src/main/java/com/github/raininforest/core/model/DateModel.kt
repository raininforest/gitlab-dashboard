package com.github.raininforest.core.model

import java.text.SimpleDateFormat
import java.util.*

data class DateModel(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int
)

fun DateModel.toDateTime(): Long {
    val cal = Calendar.getInstance()
    cal.set(Calendar.YEAR, year)
    cal.set(Calendar.MONTH, month)
    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth + 1)
    return cal.timeInMillis
}

fun DateModel.toHumanString(): String = "$dayOfMonth/${month + 1}/$year"

fun Long.toISO_8601(): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").apply {
        this.timeZone = TimeZone.getTimeZone("CST")
    }

    return formatter.format(this)
}
