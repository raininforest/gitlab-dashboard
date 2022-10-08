package com.github.raininforest.gitlabdashboard

import android.app.Application
import com.github.raininforest.gitlabdashboard.di.ApplicationComponent
import com.github.raininforest.gitlabdashboard.di.DaggerApplicationComponent
import com.github.raininforest.core.di.CoreDependenciesStore

class App : Application() {

    private val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .context(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        CoreDependenciesStore.dependencies = applicationComponent
    }
}