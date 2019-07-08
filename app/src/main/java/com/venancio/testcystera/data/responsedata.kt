package com.venancio.testcystera.data

    data class responsedata(
    val countryCode: String,
    val countryName: String,
    val dstOffset: Int,
    val gmtOffset: Int,
    val lat: Double,
    val lng: Double,
    val rawOffset: Int,
    val sunrise: String,
    val sunset: String,
    val time: String,
    val timezoneId: String
)