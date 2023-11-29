package com.example.aeon.data.api.entity

import com.example.aeon.entity.Payment
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PaymentApi(
    @Json(name = "id") override val id: Int,
    @Json(name = "title") override val title: String? = null,
    @Json(name = "amount") override val amount: String? = null,
    @Json(name = "created") override val created: Int? = null
): Payment
