package com.github.raininforest.dashboard_user_mr.ui

import com.github.raininforest.dashboard_user_mr.repository.model.UserInfo

sealed class MrDashboardUiState {
    data class Result(val data: List<UserInfo>) : MrDashboardUiState()
    object Loading : MrDashboardUiState()
}
