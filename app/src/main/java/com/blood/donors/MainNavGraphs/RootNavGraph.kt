package com.blood.donors.MainNavGraphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.blood.donors.MainNavigationScreen
import com.blood.donors.presentation.screens.CartScreen
import com.blood.donors.presentation.screens.HomeScreen
import com.blood.donors.presentation.screens.LoginScreen
import com.blood.donors.presentation.screens.ProfileScreen
import com.blood.donors.presentation.screens.SearchScreen
import com.blood.donors.presentation.screens.SignupScreen

@Composable
fun RootNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Graph.AuthGraph,
        route = Graph.RootGraph
    ) {
        // splashNavGraph(navController = navController)
        AuthNavGraph(navController = navController)
        HomeNavGraph(navController = navController)
    }
}

//Auth
fun NavGraphBuilder.AuthNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AuthGraph,
        startDestination = Route.LoginScreen.screen
    ) {
//        composable(route = Route.OnBoardingScreen.screen) {
//            OnBoardingScreen(navigateToOnBoardScreen = {
//                navController.navigate(route = Route.LoginScreen.screen)
//            })
//        }
        composable(route = Route.LoginScreen.screen) {
            LoginScreen(navController = navController, registerClicked = { s: String, s1: String ->
                if (s.isNotEmpty() && s1.isNotEmpty()) {
                    navController.navigate(route = Route.SignupScreen.screen)
                }

            })
        }
        composable(route = Route.SignupScreen.screen) {
            SignupScreen(navController = navController, loginClicked = { s: String, s1: String ->
                if (s.isNotEmpty() && s1.isNotEmpty()) {
                    navController.navigate(route = Graph.HomeNavGraph)
                }
            })
        }
    }
}

//Home
fun NavGraphBuilder.HomeNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.HomeNavGraph,
        startDestination = Route.MainScreenNavigation.screen
    ) {
        composable(route = Route.MainScreenNavigation.screen) {
            MainNavigationScreen(navController = navController)
        }
        composable(route = Route.HomeScreen.screen) {
            HomeScreen(contentPaddingValues = PaddingValues())
        }
        composable(route = Route.SearchScreen.screen) {
            SearchScreen()
        }
        composable(route = Route.CartScreen.screen) {
            CartScreen()
        }
        composable(route = Route.ProfileScreen.screen) {
            ProfileScreen()
        }
    }
}

object Graph {
    const val RootGraph = "RootGraph"
    const val OnBoardGraph = "OnBoardGraph"
    const val AuthGraph = "AuthGraph"
    const val HomeNavGraph = "HomeNavGraph"
}
