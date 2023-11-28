package com.example.aeon.ui.screens.sigin

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aeon.data.DataRepository
import com.example.aeon.entity.ErrorApp
import com.example.aeon.entity.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val errorApp: ErrorApp,
    private val dataRepository: DataRepository
): ViewModel() {

    private val _signInScreenState = MutableStateFlow(SignInScreenState())
    val signInScreenState: StateFlow<SignInScreenState> = _signInScreenState.asStateFlow()

    fun getToken(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching { dataRepository.getToken(user) }.fold(
                onSuccess = {token ->
//                    _signInScreenState.update { currentState ->
//                        currentState.token = mutableStateOf(token)
////                            currentState.token = mutableStateOf(it)
//                    }
                },
                onFailure = { errorApp.errorApi(it.message!!) }
            )
        }
    }
}