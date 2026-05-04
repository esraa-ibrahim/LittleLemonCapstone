package com.me.littlelemoncapstone

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyNavigation(navController: NavHostController, isLoggedIn: Boolean) {
    // If user data is stored in shared preferences,
    // then the start destination is Onboarding,
    // otherwise, the start destination is Home.
    var startDestination = OnBoarding.route
    if(isLoggedIn) {
        startDestination = Home.route
    }
    NavHost(navController, startDestination) {
        composable(OnBoarding.route) {
            Onboarding(navController)
        }
        composable(Home.route) {
            Home(navController)
        }
        composable(Profile.route) {
            Profile(navController)
        }
    }
}