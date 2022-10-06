package com.github.raininforest.core

interface InitializationService {
    fun setAuthData(authData: AuthData)
    fun getAuthData(): AuthData
}