package com.example.aeon.data.api

import com.example.aeon.data.api.entity.ResponsePayments
import com.example.aeon.data.api.entity.ResponseToken
import com.example.aeon.data.api.entity.UserApi
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val SERVER_API = "https://easypay.world/api-test/"

interface API {
    @Headers("Accept: application/json", "Content-type: application/json", "app-key: 12345", "v:1")
    @POST("login")
    suspend fun getToken(@Body user: UserApi): Response<ResponseToken>
    @Headers("Accept: application/json", "Content-type: application/json", "app-key: 12345", "v:1")
    @GET("payments")
    suspend fun getPayments(@Header("token") token: String): Response<ResponsePayments>
}

val retrofitApi: API by lazy {
    Retrofit
        .Builder()
        .baseUrl(SERVER_API)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(API::class.java)
}