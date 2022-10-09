package com.github.raininforest.dashboard_user_mr.repository

import com.github.raininforest.dashboard_user_mr.repository.model.UserInfo
import com.github.raininforest.dashboard_user_mr.repository.remote.dto.MergeRequestsDTOItem

class MRDashboardStatisticsBuilder {
    fun extractUsersWithHighMrCount(mrList: List<MergeRequestsDTOItem>, topCount: Int): List<UserInfo> {
        val usersMap: MutableMap<String, Int> = hashMapOf()

        mrList
            .onEach {
                val username = it.author.name
                usersMap[username] = usersMap[username]?.plus(1) ?: 1
            }

        return usersMap
            .toList()
            .sortedByDescending {
                it.second
            }
            .map {
                UserInfo(userName = it.first, mrCount = it.second.toString())
            }
            .take(topCount)
    }
}