package com.github.raininforest.home.repository

import com.github.raininforest.navigation.NavigationDestination

class HomeRepository {
    val dashboardItems: List<DashboardItem>
        get() = listOf(
            DashboardItem(text = "TOP-5 users with high MR count", link = NavigationDestination.DashboardUserMr.route),
            DashboardItem(text = EMPTY_TEXT, link = ""),
            DashboardItem(text = EMPTY_TEXT, link = ""),
            DashboardItem(text = EMPTY_TEXT, link = ""),
        )

    companion object {
        private const val EMPTY_TEXT = "empty"
    }
}