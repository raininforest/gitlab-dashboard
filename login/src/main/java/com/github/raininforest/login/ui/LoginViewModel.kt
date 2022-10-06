package com.github.raininforest.login.ui

import androidx.lifecycle.ViewModel
import com.github.raininforest.core.InitializationService
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val initializationService: InitializationService
) : ViewModel() {

    fun setHost(host: String) {
        initializationService.host = host
    }

    fun setProjectId(id: String) {
        initializationService.projectId = id
    }

    fun setToken(token: String) {
        initializationService.token = token
    }
}