package com.example.recipe.api.models

import com.google.gson.annotations.SerializedName

class CaloricBreakdownResponse {
    @SerializedName("percentProtein")
    val percentProtein: Double = 0.0
    @SerializedName("percentFat")
    val percentFat: Double = 0.0
    @SerializedName("percentCarbs")
    val percentCarbs: Double = 0.0
}