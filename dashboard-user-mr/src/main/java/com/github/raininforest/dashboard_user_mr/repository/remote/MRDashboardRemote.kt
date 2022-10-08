package com.github.raininforest.dashboard_user_mr.repository.remote

import com.github.raininforest.dashboard_user_mr.repository.remote.dto.MergeRequestsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MRDashboardRemote {

    @GET("merge_requests")
    suspend fun mergeRequests(
        @Query("created_after") createdAfter: String,
        @Query("created_before") createdBefore: String,
        @Query("state") state: String = "merged",
        @Query("per_page") perPage: String = "100"
    ): MergeRequestsDTO
}