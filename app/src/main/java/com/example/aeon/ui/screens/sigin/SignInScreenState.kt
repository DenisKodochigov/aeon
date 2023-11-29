package com.example.aeon.ui.screens.sigin

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.aeon.data.api.entity.ResponseToken
import com.example.aeon.data.api.entity.UserApi
import com.example.aeon.entity.User

data class SignInScreenState (
    var idStringScreen: Int = 0,
    val user: MutableState<User> = mutableStateOf(UserApi()),
    val enterName: MutableState<String> = mutableStateOf(""),
    val enterPass: MutableState<String> = mutableStateOf(""),
    val responseToken: MutableState<ResponseToken?> = mutableStateOf(null),
    val token: MutableState<String> = mutableStateOf(""),
    var onClickSignIn: (User) -> Unit = {},
    var passedAuthorization: (String) -> Unit = {},
    var goToScreen: (String)->Unit = {}
)