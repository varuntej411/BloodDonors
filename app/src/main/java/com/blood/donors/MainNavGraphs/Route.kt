package com.blood.donors.MainNavGraphs

sealed class Route(val screen: String) {
    data object SplashScreen: Route(screen = "splash_screen")
    data object OnBoardingScreen: Route(screen = "onboarding_screen")
    data object LoginScreen: Route(screen = "login_screen")
    data object SignupScreen: Route(screen = "signup_screen")
    data object MainScreenNavigation: Route(screen = "main_screen")
    data object HomeScreen: Route(screen = "home_screen")
    data object SearchScreen: Route(screen = "search_screen")
    data object CartScreen: Route(screen = "cart_screen")
    data object ProfileScreen: Route(screen = "profile_screen")
}