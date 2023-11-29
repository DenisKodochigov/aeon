package com.example.aeon.ui.screens.payments

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.aeon.data.api.entity.UserApi
import com.example.aeon.entity.Payment
import com.example.aeon.entity.User
data class PaymentsScreenState (
    val user: User = UserApi(),
    val userToken: MutableState<String> = mutableStateOf(""),
    var idStringScreen: Int = 0,
    val payments: MutableState<List<Payment>>? = null,
    var request: Boolean = false
)