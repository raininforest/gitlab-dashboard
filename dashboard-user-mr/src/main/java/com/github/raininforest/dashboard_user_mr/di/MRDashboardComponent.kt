package com.github.raininforest.dashboard_user_mr.di

import com.github.raininforest.core.CoreDependencies
import com.github.raininforest.dashboard_user_mr.ui.MRDashboardViewModel
import dagger.Component

@MRDashboardScope
@Component(modules = [MRDashboardModule::class], dependencies = [CoreDependencies::class])
interface MRDashboardComponent {
    val viewModel: MRDashboardViewModel
}