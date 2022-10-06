package com.github.raininforest.gitlabdashboard.service

import com.github.raininforest.core.AuthData
import com.github.raininforest.core.InitializationService
import com.github.raininforest.core.PreferenceService

class InitializationServiceImpl(private val preferenceService: PreferenceService) : InitializationService {
    private var _authData: AuthData = AuthData()

    override fun setAuthData(authData: AuthData) {
        _authData = authData
        preferenceService.saveToPreferences(
            mapOf(
                HOST_KEY to authData.host,
                PROJECT_ID_KEY to authData.projectId,
                TOKEN_KEY to authData.token
            )
        )
    }

    override fun getAuthData(): AuthData = if (_authData.isValid()) {
        _authData
    } else {
        AuthData(
            host = preferenceService.loadStringFromPreferences(HOST_KEY),
            projectId = preferenceService.loadStringFromPreferences(PROJECT_ID_KEY),
            token = preferenceService.loadStringFromPreferences(TOKEN_KEY)
        )
    }

    private fun AuthData.isValid(): Boolean = host.isNotEmpty() && projectId.isNotEmpty() && token.isNotEmpty()

    companion object {
        private const val HOST_KEY = "host_key"
        private const val PROJECT_ID_KEY = "project_id__key"
        private const val TOKEN_KEY = "token_key"
    }
}