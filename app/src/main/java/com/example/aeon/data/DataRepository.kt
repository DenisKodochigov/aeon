package com.example.aeon.data

import com.example.aeon.data.api.DataSourceApi
import com.example.aeon.data.api.entity.UserApi
import com.example.aeon.data.api.retrofitApi
import com.example.aeon.entity.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(private val dataSource: DataSourceApi) {

    suspend fun getToken(user: User) = dataSource.getToken(user = user)?.token ?: ""
}