package com.github.raininforest.core.di

import com.github.raininforest.core.service.InitializationService
import com.github.raininforest.core.service.PreferenceService
import retrofit2.Retrofit

interface CoreDependencies {
    val initializationService: InitializationService
    val preferenceService: PreferenceService
    val retrofit: Retrofit
}