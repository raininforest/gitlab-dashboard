package com.github.raininforest.dashboard_user_mr.repository.remote

import android.util.Log
import com.github.raininforest.core.TAG
import com.github.raininforest.dashboard_user_mr.repository.remote.dto.MergeRequestsDTO
import com.github.raininforest.dashboard_user_mr.repository.remote.dto.MergeRequestsDTOItem
import kotlinx.coroutines.delay
import retrofit2.Response

class PaginatedRemoteMrDataSource(
    private val mrDashboardRemote: MRDashboardRemote
) {
    suspend fun fetchMRs(createdAfter: String, createdBefore: String): List<MergeRequestsDTOItem> {
        val result = mutableListOf<MergeRequestsDTOItem>()

        val initialResult = loadInitial(createdAfter, createdBefore)
        result.addAll(initialResult.mRs.orEmpty())
        val totalPages: Int = initialResult.totalPages?.toInt() ?: 1
        var page: Int = initialResult.page?.toInt() ?: 1

        Log.d(TAG, "MRResponse: totalPages=$totalPages page=$page")

        while (page < totalPages) {
            result.addAll(loadPage(createdAfter, createdBefore, (++page).toString()).mRs.orEmpty())
            delay(100)
            Log.d(TAG, "MRResponse: totalPages=$totalPages page=$page")
        }

        return result
    }

    private suspend fun loadInitial(createdAfter: String, createdBefore: String): MRResponse {
        val retrofitResponse = mrDashboardRemote.mergeRequests(createdAfter, createdBefore)
        return retrofitResponse.toMRResponse()
    }

    private suspend fun loadPage(createdAfter: String, createdBefore: String, page: String): MRResponse {
        val retrofitResponse = mrDashboardRemote.mergeRequests(createdAfter, createdBefore, page)
        return retrofitResponse.toMRResponse()
    }

    private fun Response<MergeRequestsDTO>.toMRResponse(): MRResponse {
        return MRResponse(
            mRs = body(),
            totalPages = headers()["x-total-pages"],
            page = headers()["x-page"]
        )
    }
}
