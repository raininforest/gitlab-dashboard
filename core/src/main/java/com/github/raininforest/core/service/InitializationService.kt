package com.github.raininforest.core.service

import com.github.raininforest.core.model.AuthData

interface InitializationService {
    fun setAuthData(authData: AuthData)
    fun getAuthData(): AuthData
}