package com.example.aeon.data.api.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseToken(
    @Json(name = "success") val success: String,
    @Json(name = "response") val response: Token
)


