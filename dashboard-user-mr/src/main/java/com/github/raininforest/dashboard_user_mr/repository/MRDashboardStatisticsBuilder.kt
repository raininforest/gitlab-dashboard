package com.github.raininforest.dashboard_user_mr.repository

import com.github.raininforest.dashboard_user_mr.repository.model.UserInfo
import com.github.raininforest.dashboard_user_mr.repository.remote.dto.Author
import com.github.raininforest.dashboard_user_mr.repository.remote.dto.MergeRequestsDTOItem

class MRDashboardStatisticsBuilder {
    fun extractUsersWithHighMrCount(mrList: List<MergeRequestsDTOItem>, topCount: Int): List<UserInfo> {
        val usersMap: MutableMap<Author, Int> = hashMapOf()

        mrList
            .onEach {
                val author = it.author
                usersMap[author] = usersMap[author]?.plus(1) ?: 1
            }

        return usersMap
            .toList()
            .sortedByDescending {
                it.second
            }
            .map {
                UserInfo(userName = it.first.name, mrCount = it.second.toString(), avaUrl = it.first.avatar_url)
            }
            .take(topCount)
    }
}