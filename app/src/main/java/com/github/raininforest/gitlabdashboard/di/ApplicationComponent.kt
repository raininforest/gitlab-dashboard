package com.github.raininforest.gitlabdashboard.di

import com.github.raininforest.core.InitializationService
import com.github.raininforest.core.CoreDependencies
import dagger.Component
import retrofit2.Retrofit

@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent : CoreDependencies {
    override val initializationService: InitializationService
    override val retrofit: Retrofit
}
