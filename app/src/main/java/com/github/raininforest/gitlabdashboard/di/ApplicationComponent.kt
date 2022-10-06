package com.github.raininforest.gitlabdashboard.di

import android.content.Context
import com.github.raininforest.core.CoreDependencies
import com.github.raininforest.core.InitializationService
import com.github.raininforest.core.PreferenceService
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit

@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent : CoreDependencies {
    override val initializationService: InitializationService
    override val preferenceService: PreferenceService
    override val retrofit: Retrofit

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): ApplicationComponent
    }
}
