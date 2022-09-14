package com.devpass.spaceapp.data.api.response

import com.google.gson.annotations.SerializedName

data class LaunchpadDetailResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("locality")
    val locality: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("launch_attempts")
    val launchAttempts: Int,
    @SerializedName("launch_successes")
    val launchSuccesses: Int,
)
