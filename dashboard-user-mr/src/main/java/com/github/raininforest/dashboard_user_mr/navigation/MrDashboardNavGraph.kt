package com.github.raininforest.dashboard_user_mr.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.github.raininforest.core.di.CoreDependenciesProvider
import com.github.raininforest.dashboard_user_mr.di.DaggerMRDashboardComponent
import com.github.raininforest.dashboard_user_mr.ui.MrDashboardScreen
import com.github.raininforest.datepicker.ui.DatePickerScreen
import com.github.raininforest.navigation.NavigationDestination
import com.github.raininforest.navigation.daggerViewModel

fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(
        startDestination = NavigationDestination.DatePicker.route,
        route = NavigationDestination.MrDashboard.route
    ) {
        val component = DaggerMRDashboardComponent.builder()
            .coreDependencies(CoreDependenciesProvider.dependencies)
            .build()

        composable(NavigationDestination.DatePicker.route) {
            DatePickerScreen(viewModel = daggerViewModel { component.datePickerViewModel }, onNextClick = {
                navController.navigate(
                    NavigationDestination.DashboardUserMr.route
                )
            })
        }
        composable(NavigationDestination.DashboardUserMr.route) {
            MrDashboardScreen(viewModel = daggerViewModel { component.mrDashboardViewModel })
        }
    }
}