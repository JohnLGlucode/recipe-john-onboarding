package com.example.recipe.models

import com.google.gson.annotations.SerializedName

class Measurement {
    @SerializedName("amount")
    var amount: Double = 0.0
    @SerializedName("unitLong")
    var unitLong: String? = null
    @SerializedName("unitShort")
    var unitShort: String? = null
}