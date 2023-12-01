package com.example.aeon.data.api

import com.example.aeon.data.api.entity.PaymentApi
import com.example.aeon.data.api.entity.ResponseToken
import com.example.aeon.data.api.entity.Token
import com.example.aeon.data.api.entity.UserApi
import com.example.aeon.entity.Payment
import com.example.aeon.entity.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSourceApi @Inject constructor() {
    suspend fun getToken(user: User): ResponseToken? {
//        return retrofitApi.getToken(user = user as UserApi).body()
        return ResponseToken(success = "true", response = Token( token = "111111111111"))
    }

    suspend fun getPayments(userToken: String): List<Payment>
    {
        val result = retrofitApi.getPayments(token = userToken).body()
//        return result?.response ?: emptyList()
        return listOf(
            PaymentApi(id = 1, title = "Title 1", amount = "1.0", created = 1234552132),
            PaymentApi(id = 2, title = "Title 2", amount = "2.0", created = 1244552132),
            PaymentApi(id = 3, title = "Title 3", amount = "3.0", created = 1254552132),)
    }
}