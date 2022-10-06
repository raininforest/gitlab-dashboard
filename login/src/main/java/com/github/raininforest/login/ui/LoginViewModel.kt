package com.github.raininforest.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.raininforest.core.AuthData
import com.github.raininforest.core.InitializationService
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val initializationService: InitializationService
) : ViewModel() {

    private val _host = MutableLiveData<String>("")
    private val _projectId = MutableLiveData<String>("")
    private val _token = MutableLiveData<String>("")
    val host: LiveData<String>
        get() = _host
    val projectId: LiveData<String>
        get() = _projectId
    val token: LiveData<String>
        get() = _token

    init {
        val authData = initializationService.getAuthData()
        _host.value = authData.host
        _projectId.value = authData.projectId
        _token.value = authData.token
    }

    fun setHost(host: String) {
        _host.value = host
    }

    fun setProjectId(projectId: String) {
        _projectId.value = projectId
    }

    fun setToken(token: String) {
        _token.value = token
    }

    fun onGo() {
        initializationService.setAuthData(
            AuthData(
                _host.value ?: "",
                _projectId.value ?: "",
                _token.value ?: ""
            )
        )
    }
}