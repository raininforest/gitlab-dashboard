package com.github.raininforest.navigation

sealed class NavigationDestination(val route: String) {
    object Login : NavigationDestination("login")
    object Home : NavigationDestination("home")
    object DashboardUserMr : NavigationDestination("mrDashboardø")
}
