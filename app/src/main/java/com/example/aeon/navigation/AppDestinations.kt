package com.example.aeon.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.aeon.R

interface ScreenDestination {
    val route: String
    val textHeader: Int
    val logOut: ()->Unit
}
object LoginDestination : ScreenDestination {
    override val route = "signin"
    override val textHeader = R.string.signin
    override val logOut: () -> Unit
        get() = { }
}
object PaymentsDestination : ScreenDestination {
    override val route = "payments"
    override val textHeader = R.string.payments
    override val logOut: () -> Unit = {}
    const val userIdArg = "user_token"
    val routeWithArgs = "${route}/{$userIdArg}"
    val arguments = listOf(navArgument(userIdArg) { type = NavType.StringType })
}
