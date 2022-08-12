package com.example.recipe.api.models

import com.google.gson.annotations.SerializedName

class MeasurementResponse {
    @SerializedName("amount")
    var amount: Double = 0.0
    @SerializedName("unitLong")
    var unitLong: String? = null
    @SerializedName("unitShort")
    var unitShort: String? = null
}