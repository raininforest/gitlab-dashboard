package com.github.raininforest.core

import retrofit2.Retrofit

interface CoreDependencies {
    val initializationService: InitializationService
    val retrofit: Retrofit
}