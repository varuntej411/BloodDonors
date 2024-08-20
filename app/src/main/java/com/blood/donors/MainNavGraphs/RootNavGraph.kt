package com.blood.donors.MainNavGraphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.blood.donors.MainNavigationScreen
import com.blood.donors.presentation.screens.LoginScreen

@Composable
fun SetUpNavGraph(navController: NavHostController, contentPaddingValues: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = Route.SplashScreen.screen,
        route = Graph.RootGraph
    ) {
        // splashNavGraph(navController = navController)
        AuthNavGraph(navController = navController)
        HomeNavGraph(navController = navController, contentPaddingValues = contentPaddingValues)
    }
}

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AuthGraph,
        startDestination = Route.LoginScreen.screen
    ) {
        composable(route = Route.LoginScreen.screen) {
            LoginScreen(navController = navController)
        }
    }
}

fun NavGraphBuilder.HomeNavGraph(navController: NavHostController, contentPaddingValues: PaddingValues) {
    navigation(
        route = Graph.HomeNavGraph,
        startDestination = Route.MainScreenNavigation.screen
    ) {
        composable(route = Route.MainScreenNavigation.screen) {
            MainNavigationScreen(navController = navController)
        }
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

object Graph {
    const val RootGraph = "RootGraph"
    const val OnBoardGraph = "OnBoardGraph"
    const val AuthGraph = "AuthGraph"
    const val HomeNavGraph = "HomeNavGraph"
}
