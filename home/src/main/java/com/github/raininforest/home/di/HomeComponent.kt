package com.github.raininforest.home.di

import com.github.raininforest.home.ui.HomeViewModel
import dagger.Component

@HomeScope
@Component(modules = [HomeModule::class])
interface HomeComponent {
    val viewModel: HomeViewModel
}