package com.example.aeon.data.api

import com.example.aeon.data.api.entity.Token
import com.example.aeon.data.api.entity.UserApi
import com.example.aeon.entity.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSourceApi @Inject constructor() {

    suspend fun getToken(user: User): Token? {
        val response = retrofitApi.getToken(user = user as UserApi).body()
        return response?.response
    }
}