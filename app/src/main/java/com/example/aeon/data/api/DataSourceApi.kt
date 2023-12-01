package com.example.aeon.data.api

import com.example.aeon.data.api.entity.ResponseToken
import com.example.aeon.data.api.entity.UserApi
import com.example.aeon.entity.Payment
import com.example.aeon.entity.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSourceApi @Inject constructor() {
    suspend fun getToken(user: User): ResponseToken? = retrofitApi.getToken(user = user as UserApi).body()

    suspend fun getPayments(userToken: String): List<Payment>
    {
        val result = retrofitApi.getPayments(token = userToken).body()
        return result?.response ?: emptyList()
    }
}