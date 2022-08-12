package com.example.recipe.api.models

import com.google.gson.annotations.SerializedName

class WeightPerServingResponse {
    @SerializedName("amount")
    val amount: Int = 0
    @SerializedName("unit")
    val unit: String? = null
}