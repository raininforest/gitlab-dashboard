package com.github.raininforest.dashboard_user_mr.di

import com.github.raininforest.core.di.CoreDependencies
import com.github.raininforest.dashboard_user_mr.ui.MRDashboardViewModel
import com.github.raininforest.datepicker.ui.DatePickerViewModel
import dagger.Component

@MRDashboardScope
@Component(modules = [MRDashboardModule::class, DateStorageModule::class], dependencies = [CoreDependencies::class])
interface MRDashboardComponent {
    val datePickerViewModel: DatePickerViewModel
    val mrDashboardViewModel: MRDashboardViewModel
}