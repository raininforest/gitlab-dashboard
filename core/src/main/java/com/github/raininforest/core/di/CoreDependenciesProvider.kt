package com.github.raininforest.core.di

import kotlin.properties.Delegates.notNull

interface CoreDependenciesProvider {
    val dependencies: CoreDependencies

    companion object : CoreDependenciesProvider by CoreDependenciesStore
}

object CoreDependenciesStore : CoreDependenciesProvider {
    override var dependencies: CoreDependencies by notNull()
}