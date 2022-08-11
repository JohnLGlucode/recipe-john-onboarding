package com.example.recipe.models

import com.google.gson.annotations.SerializedName

class CaloricBreakdown {
    @SerializedName("percentProtein")
    val percentProtein: Double = 0.0
    @SerializedName("percentFat")
    val percentFat: Double = 0.0
    @SerializedName("percentCarbs")
    val percentCarbs: Double = 0.0
}