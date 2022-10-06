package com.github.raininforest.core

import retrofit2.Retrofit

interface CoreDependencies {
    val initializationService: InitializationService
    val preferenceService: PreferenceService
    val retrofit: Retrofit
}