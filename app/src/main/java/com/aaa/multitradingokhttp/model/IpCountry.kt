package com.aaa.multitradingokhttp.model

import com.google.gson.annotations.SerializedName

// JSON 1
data class IpCountry(val ip: String, val city: String,
    val region: String, val region_code: Any, val country: String,
    val country_name: String, val continent_code: String,
    val in_eu: Boolean, val postal: Any, val latitude: Double,
    val longitude: Double, val timezone: Any, val utc_offset: Any,
    val country_calling_code: String, val currency: String, val languages: String,
    val asn: String, val org: String
)
// JSON 2
data class DogResponse(@SerializedName("message")  val imagesList: List<String>? = null)

// JSON 2
data class UserData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)
