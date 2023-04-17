package com.myprojects.shaddaiapi.ui.theme.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.myprojects.shaddaiapi.navigation.AppScreens


@Composable
fun NavigationComponent(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = "/splash",
        modifier = modifier
    ) {
       // splashScreen()
        navHostController.popBackStack()
        navHostController.navigate(AppScreens.HomeScreen.route)
    }
}

