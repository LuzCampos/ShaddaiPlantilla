package com.myprojects.shaddaiapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myprojects.shaddaiapi.ui.theme.ShaddaiApiTheme
import com.myprojects.shaddaiapi.ui.theme.home.*
import com.myprojects.shaddaiapi.ui.theme.login.LoginScreen
import com.myprojects.shaddaiapi.ui.theme.login.RegisterScreen
import com.myprojects.shaddaiapi.ui.theme.login.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModelCart by viewModels<CartViewModel>()
    private val homeViewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShaddaiApiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController, // the navController created above
                        startDestination = "splash" // start destination variable needs to match one of the composable screen routes below
                    ) {
                        composable("splash") { SplashScreen(navController) }
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("register") {
                            RegisterScreen(navController)
                        }
                        composable("home") {
                            HomeScreen(navController,
                               // viewModelCart
                            )
                        }
                        composable("detailproduct/{_id}") {
                                backStackEntry ->
                            DetailProductScreen(_id = backStackEntry.arguments?.getString(
                                "_id"), homeViewModel = homeViewModel, navController = navController )
                        }
                        composable("cart") {
                            CarritoItemsScreen(navController)
                        }
                    }

                }
            }
        }
    }
}
