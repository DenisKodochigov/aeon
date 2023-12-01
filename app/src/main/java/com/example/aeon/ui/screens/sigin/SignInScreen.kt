package com.example.aeon.ui.screens.sigin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.aeon.R
import com.example.aeon.data.api.entity.UserApi
import com.example.aeon.entity.Authorization
import com.example.aeon.entity.TypeKeyboard
import com.example.aeon.navigation.ScreenDestination
import com.example.aeon.ui.components.ButtonApp
import com.example.aeon.ui.components.HeaderScreen
import com.example.aeon.ui.components.OutlinedTextFieldMy
import com.example.aeon.ui.theme.Dimen

@Composable fun  SignInScreen(
    screen: ScreenDestination,
    passedAuthorization: (String) ->Unit,
    goToScreen: (String)->Unit
){
    val viewModel: SignInViewModel = hiltViewModel()

    SignInScreenCreateView(
        screen = screen,
        viewModel = viewModel,
        passedAuthorization = passedAuthorization,
        goToScreen = goToScreen
    )
}
@Composable fun SignInScreenCreateView(
    screen: ScreenDestination,
    viewModel: SignInViewModel,
    passedAuthorization: (String) ->Unit,
    goToScreen: (String)->Unit
){
    val uiState by viewModel.signInScreenState.collectAsState()
    uiState.onClickSignIn = {viewModel.getToken(it)}
    uiState.idStringScreen = screen.textHeader
    uiState.passedAuthorization = { token -> passedAuthorization(token) }
    uiState.goToScreen = { route -> goToScreen(route) }

    if (Authorization.token == ""){
        uiState.enterName.value = ""
        uiState.enterPass.value = ""
    }
    SignInScreenLayout( uiState = uiState )
}
@Composable fun SignInScreenLayout(uiState: SignInScreenState
){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(Dimen.paddingElement))
        HeaderScreen(text = stringResource(uiState.idStringScreen) )
        Spacer(modifier = Modifier.height(Dimen.paddingHeaderScreen))
        FieldName(uiState = uiState)
        Spacer(modifier = Modifier.height(Dimen.paddingElement))
        FieldPassword(uiState = uiState)
        Spacer(modifier = Modifier.height(Dimen.paddingElement))
        ButtonSignIn(uiState = uiState)
        Spacer(modifier = Modifier.height(Dimen.paddingHeaderScreen))
        ButtonGoPayments(uiState = uiState)
        Spacer(modifier = Modifier.height(Dimen.paddingHeaderScreen))
    }
}

@Composable fun FieldName(uiState: SignInScreenState){
    OutlinedTextFieldMy(
        modifier = Modifier,
        enterValue = uiState.enterName,
        typeKeyboard = TypeKeyboard.TEXT,
        label = R.string.enterName,
        keyboardActionsOnDone = {}
   )
}
@Composable fun FieldPassword(uiState: SignInScreenState){
    OutlinedTextFieldMy(
        modifier = Modifier,
        enterValue = uiState.enterPass,
        typeKeyboard = TypeKeyboard.PASSWORD,
        label = R.string.enterPass,
        keyboardActionsOnDone = {}
    )
}
@Composable fun ButtonSignIn(uiState: SignInScreenState)
{
    ButtonApp(
        modifier = Modifier,
        text = stringResource(R.string.ok),
        onClick = {
            uiState.onClickSignIn(
                UserApi(login = uiState.enterName.value, password =  uiState.enterPass.value))
        },
        enabled = true
   )
}
@Composable fun ButtonGoPayments(uiState: SignInScreenState)
{
    ButtonApp(
        modifier = Modifier,
        text = stringResource(R.string.go_to_payments),
        onClick = { uiState.passedAuthorization( Authorization.token ) },
        enabled = Authorization.token != ""
    )
}
