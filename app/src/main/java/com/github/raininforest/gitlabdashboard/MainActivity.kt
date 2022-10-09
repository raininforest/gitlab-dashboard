package com.github.raininforest.gitlabdashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.raininforest.core.di.CoreDependenciesProvider
import com.github.raininforest.dashboard_user_mr.navigation.loginGraph
import com.github.raininforest.gitlabdashboard.ui.theme.GitlabDashboardTheme
import com.github.raininforest.home.di.DaggerHomeComponent
import com.github.raininforest.home.ui.HomeScreen
import com.github.raininforest.login.di.DaggerLoginComponent
import com.github.raininforest.login.ui.LoginScreen
import com.github.raininforest.navigation.NavigationDestination
import com.github.raininforest.navigation.daggerViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitlabDashboardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable(NavigationDestination.Login.route) {
            LoginScreen(viewModel = daggerViewModel {
                DaggerLoginComponent.builder().deps(CoreDependenciesProvider.dependencies).build().loginViewModel
            }, onGo = { navController.navigate(NavigationDestination.Home.route) })
        }
        composable(NavigationDestination.Home.route) {
            HomeScreen(viewModel = daggerViewModel {
                DaggerHomeComponent.create().viewModel
            }, onItemClick = { link -> if (link.isEmpty().not()) navController.navigate(link) })
        }
        loginGraph(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GitlabDashboardTheme {
        Box(
            Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colors.primary,
                strokeWidth = 4.dp
            )
        }
    }
}