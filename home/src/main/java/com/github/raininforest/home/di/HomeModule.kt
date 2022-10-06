package com.github.raininforest.home.di

import com.github.raininforest.home.repository.HomeRepository
import dagger.Module
import dagger.Provides

@Module
object HomeModule {

    @Provides
    @HomeScope
    fun provideHomeRepository(): HomeRepository = HomeRepository()
}
