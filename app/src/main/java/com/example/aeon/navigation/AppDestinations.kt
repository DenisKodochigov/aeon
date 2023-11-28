package com.example.aeon.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.aeon.R

/*** Contract for information needed on every App navigation destination*/
interface ScreenDestination {
    val icon: ImageVector
    val route: String
    var textFAB: String
    val textHeader: Int
    var onClickFAB: () -> Unit
}

/*** App app navigation destinations*/
object LoginDestination : ScreenDestination {
    override val icon = Icons.Filled.ShoppingBasket
    override val route = "signin"
    override var textFAB = ""
    override val textHeader = R.string.signin
    override var onClickFAB: () -> Unit = {  }
}

object PaymentsDestination : ScreenDestination {
    override val icon = Icons.Filled.Dashboard
    override val route = "payments"
    override var textFAB = ""
    const val userIdArg = "user_token"
    val routeWithArgs = "${route}/{$userIdArg}"
    val arguments = listOf(navArgument(userIdArg) { type = NavType.LongType })
    override val textHeader = R.string.payments
    override var onClickFAB: () -> Unit = {  }
}

val appTabRowScreens = listOf(LoginDestination, LoginDestination) //, TestDestination)
val listScreens = listOf(LoginDestination, LoginDestination)
