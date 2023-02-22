package com.myprojects.shaddaiapi.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.myprojects.shaddaiapi.ui.theme.home.HomeScreen
import com.myprojects.shaddaiapi.ui.theme.login.SplashScreen



class AppDestination {
    companion object {
        const val route = "/splash"
        const val home = "/home"
    }
}


fun NavGraphBuilder.splashScreen() {
    composable(AppDestination.route) {
        SplashScreen()
    }
}

fun NavGraphBuilder.homeScreen() {
    composable(AppDestination.home) {
        HomeScreen()
    }
}