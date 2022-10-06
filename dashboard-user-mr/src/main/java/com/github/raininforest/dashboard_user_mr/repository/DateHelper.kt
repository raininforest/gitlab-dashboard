package com.github.raininforest.dashboard_user_mr.repository

import java.text.SimpleDateFormat
import java.util.*

class DateHelper {
    fun calculateDate(daysAgo: Int): String {
        val nowDateMs = Date().time
        val daysAgoDateMs = nowDateMs - (daysAgo * 24L * 60L * 60L * 1000L)
        val dateAgo = Date(daysAgoDateMs)

        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").apply {
            this.timeZone = TimeZone.getTimeZone("CST")
        }

        return formatter.format(dateAgo)
    }
}
