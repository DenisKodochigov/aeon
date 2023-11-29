package com.example.aeon.ui.screens.payments

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aeon.data.DataRepository
import com.example.aeon.data.api.entity.UserApi
import com.example.aeon.entity.ErrorApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val errorApp: ErrorApp,
    private val dataRepository: DataRepository
): ViewModel() {

    private val _paymentScreenState = MutableStateFlow(PaymentsScreenState(request = true))
    val paymentScreenState: StateFlow<PaymentsScreenState> = _paymentScreenState.asStateFlow()

    fun getPayments(userToken: String) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching { dataRepository.getPayments(userToken = userToken) }.fold(
                onSuccess = {
                    _paymentScreenState.update { currentState ->
                        currentState.copy( payments = mutableStateOf(it)) }
                 },
                onFailure = { errorApp.errorApi(it.message!!) }
            )
        }
    }
}