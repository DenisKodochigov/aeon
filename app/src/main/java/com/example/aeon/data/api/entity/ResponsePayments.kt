package com.example.aeon.data.api.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class ResponsePayments(
    @Json(name = "success") val success: String,
    @Json(name = "response") val response: List<PaymentApi>
)
