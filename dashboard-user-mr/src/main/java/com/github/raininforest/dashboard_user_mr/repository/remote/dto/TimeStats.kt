package com.github.raininforest.dashboard_user_mr.repository.remote.dto

data class TimeStats(
    val human_time_estimate: Any,
    val human_total_time_spent: Any,
    val time_estimate: Int,
    val total_time_spent: Int
)