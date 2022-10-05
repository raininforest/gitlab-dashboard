package com.github.raininforest.gitlabdashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.raininforest.dashboard_user_mr.ui.MrDashboardScreen
import com.github.raininforest.gitlabdashboard.ui.theme.GitlabDashboardTheme
import com.github.raininforest.home.ui.HomeScreen
import com.github.raininforest.login.ui.LoginScreen
import com.github.raininforest.navigation.NavigationDestination

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
            LoginScreen(onAuthorize = { navController.navigate(NavigationDestination.Home.route) })
        }
        composable(NavigationDestination.Home.route) {
            HomeScreen(onItemClick = { link -> navController.navigate(link) })
        }
        composable(NavigationDestination.DashboardUserMr.route) { MrDashboardScreen() }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GitlabDashboardTheme {
        //LoginScreen()
        //HomeScreen()
        //MrDashboardScreen()
    }
}