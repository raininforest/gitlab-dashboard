package com.github.raininforest.dashboard_user_mr.repository

import com.github.raininforest.core.model.toISO_8601
import com.github.raininforest.dashboard_user_mr.repository.model.UserInfo
import com.github.raininforest.dashboard_user_mr.repository.remote.MRDashboardRemote
import com.github.raininforest.datepicker.service.DateStorage
import java.util.*

class MRDashboardRepository(
    private val dashboardRemote: MRDashboardRemote,
    private val dashboardStatisticsBuilder: MRDashboardStatisticsBuilder,
) : DateStorage {

    private var _fromDate: Long = Date().time
    override var fromDate: Long
        set(value) {
            _fromDate = value
        }
        get() = _fromDate

    private var _toDate: Long = Date().time
    override var toDate: Long
        set(value) {
            _toDate = value
        }
        get() = _toDate

    suspend fun data(): List<UserInfo> =
        dashboardStatisticsBuilder.extractUsersWithHighMrCount(
            mrList = dashboardRemote
                .mergeRequests(createdAfter = _fromDate.toISO_8601(), createdBefore = _toDate.toISO_8601()),
            topCount = TOP_COUNT
        )

    companion object {
        private const val TOP_COUNT = 5
    }
}