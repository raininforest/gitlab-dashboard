package com.github.raininforest.dashboard_user_mr.repository.remote

import com.github.raininforest.dashboard_user_mr.repository.remote.dto.MergeRequestsDTO

data class MRResponse(
    val mRs: MergeRequestsDTO?,
    val totalPages: String?,
    val page: String?
)
