package com.github.raininforest.dashboard_user_mr.repository

import com.github.raininforest.dashboard_user_mr.repository.model.UserInfo
import com.github.raininforest.dashboard_user_mr.repository.remote.MRDashboardRemote

class MRDashboardRepository(
    private val dashboardRemote: MRDashboardRemote,
    private val dashboardStatisticsBuilder: MRDashboardStatisticsBuilder,
    private val dateHelper: DateHelper
) {
    suspend fun data(daysAgo: Int = DAYS_COUNT): List<UserInfo> =
        dashboardStatisticsBuilder.extractUsersWithHighMrCount(
            mrList = dashboardRemote.mergeRequests(dateHelper.calculateDate(daysAgo)),
            topCount = TOP_COUNT
        )

    companion object {
        private const val DAYS_COUNT = 21
        private const val TOP_COUNT = 5
    }
}