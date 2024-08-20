package com.blood.donors.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.blood.donors.MainNavGraphs.Route

@Composable
fun NavigationGraph(
    navController: NavHostController,
    contentPaddingValues: PaddingValues
) {
    NavHost(navController = navController, startDestination = Route.MainScreenNavigation.screen, route = Route.HomeScreen.screen) {

        composable(route = Route.HomeScreen.screen) {
            //HomeScreen(contentPaddingValues = contentPaddingValues)
        }
        composable(route = Route.SearchScreen.screen) {
           // SearchScreen()
        }
        composable(route = Route.CartScreen.screen) {
           // CartScreen()
        }
        composable(route = Route.ProfileScreen.screen) {
           // ProfileScreen()
        }
    }
}
