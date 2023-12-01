package com.example.aeon.data

import com.example.aeon.data.api.DataSourceApi
import com.example.aeon.entity.Payment
import com.example.aeon.entity.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(private val dataSource: DataSourceApi) {
    suspend fun getToken(user: User) = dataSource.getToken(user = user)
    suspend fun getPayments(userToken: String): List<Payment> =
        dataSource.getPayments(userToken = userToken)
}