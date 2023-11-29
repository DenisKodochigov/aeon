package com.example.aeon.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

fun NavHostController.navigateToScreen(route: String) =
    this.navigate(route) {
        launchSingleTop = true
        popUpTo(this@navigateToScreen.graph.findStartDestination().id) {
            saveState = true
        }
    }

fun NavHostController.navigateToPayment(userIdArg: String) {
    this.navigateToScreen("${PaymentsDestination.route}/$userIdArg")
}