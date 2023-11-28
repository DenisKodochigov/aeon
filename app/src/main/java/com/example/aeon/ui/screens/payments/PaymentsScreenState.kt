package com.example.aeon.ui.screens.payments

import com.example.aeon.data.api.entity.UserApi
import com.example.aeon.entity.User

class PaymentsScreenState {
    val user: User = UserApi()
    val token: String = ""
}