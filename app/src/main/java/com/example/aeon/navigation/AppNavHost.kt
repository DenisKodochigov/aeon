package com.example.aeon.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aeon.ui.screens.payments.PaymentsScreen
import com.example.aeon.ui.screens.sigin.SignInScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
){

    NavHost(
        navController = navController, startDestination = LoginDestination.route, modifier = modifier ) {
        composable(route = LoginDestination.route,
            enterTransition = {
                targetState.destination.route?.let { enterTransition(LoginDestination.route, it) } },
            exitTransition = {
                targetState.destination.route?.let { exitTransition(LoginDestination.route, it)  } }) {
            SignInScreen(screen = LoginDestination )
        }
        composable(
            route = PaymentsDestination.routeWithArgs, arguments = PaymentsDestination.arguments,
            enterTransition = {
                targetState.destination.route?.let { enterTransition(LoginDestination.route, it) } },
            exitTransition = {
                targetState.destination.route?.let { exitTransition(LoginDestination.route, it)  } }
        )
        { navBackStackEntry ->
            val userId = navBackStackEntry.arguments?.getLong(PaymentsDestination.userIdArg)
            if (userId != null) {
                PaymentsScreen(userToken = userId, screen = PaymentsDestination)
            }
        }
    }
}

fun enterTransition(defaultScreen: String, targetScreen: String): EnterTransition{
    val durationMillis = 800
    val delayMillis = 200
    return if (targetScreen == defaultScreen) {
        slideInHorizontally(
            animationSpec = tween( durationMillis = durationMillis, delayMillis = delayMillis)) { it / -1 } +
                fadeIn( animationSpec = tween(durationMillis = durationMillis, delayMillis = delayMillis))
    } else {
        slideInHorizontally(
            animationSpec = tween(durationMillis = durationMillis, delayMillis = delayMillis)) { it / 1 } +
                fadeIn( animationSpec = tween(durationMillis = durationMillis, delayMillis = delayMillis))
    }
}
fun exitTransition(defaultScreen: String, targetScreen: String): ExitTransition {
    val durationMillis = 800
    val delayMillis = 200
    return if (targetScreen == defaultScreen) {
        slideOutHorizontally(
            animationSpec = tween(durationMillis = durationMillis, delayMillis = delayMillis)) { it / 1 } +
                fadeOut(animationSpec = tween(durationMillis = durationMillis, delayMillis = delayMillis))
    } else {
        slideOutHorizontally(
            animationSpec = tween(durationMillis = durationMillis, delayMillis = delayMillis)) { it / -1 } +
                fadeOut(animationSpec = tween(durationMillis = durationMillis, delayMillis = delayMillis))
    }
}

