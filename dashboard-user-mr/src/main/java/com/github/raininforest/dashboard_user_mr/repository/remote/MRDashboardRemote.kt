package com.github.raininforest.dashboard_user_mr.repository.remote

import com.github.raininforest.dashboard_user_mr.repository.remote.dto.MergeRequestsDTO
import retrofit2.http.GET

interface MRDashboardRemote {

    @GET("merge_requests")
    suspend fun mergeRequests(): MergeRequestsDTO
}