package com.github.raininforest.dashboard_user_mr.repository

import com.github.raininforest.dashboard_user_mr.repository.model.UserInfo
import com.github.raininforest.dashboard_user_mr.repository.remote.MRDashboardRemote

class MRDashboardRepository(
    private val dashboardRemote: MRDashboardRemote,
    private val dashboardStatisticsBuilder: MRDashboardStatisticsBuilder
) {
    suspend fun data(): List<UserInfo> =
        dashboardStatisticsBuilder.extractUsersWithHighMrCount(
            mrList = dashboardRemote.mergeRequests(),
            topCount = 10
        )
}