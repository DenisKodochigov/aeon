package com.example.aeon.navigation

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
        navController = navController,
        startDestination = LoginDestination.route,
        modifier = modifier
    ){
        composable(route = LoginDestination.route,
        ){
            SignInScreen(screen = LoginDestination,
                passedAuthorization = { navController.navigateToPayment(it) },
                goToScreen = { navController.navigateToScreen(it)})
        }
        composable(
            route = PaymentsDestination.routeWithArgs,
            arguments = PaymentsDestination.arguments,
        ){ navBackStackEntry ->
            val userId = navBackStackEntry.arguments?.getString(PaymentsDestination.userIdArg)
            if (userId != null) {
                PaymentsScreen(userToken = userId, screen = PaymentsDestination, )
            }
        }
    }
}


