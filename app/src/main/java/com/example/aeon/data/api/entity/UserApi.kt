package com.example.aeon.data.api.entity

import com.example.aeon.entity.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserApi(
    @Json(name = "login") override val login: String = "",
    @Json(name = "password") override val password: String = "",
): User