package com.example.recipe.models

import com.google.gson.annotations.SerializedName

class WeightPerServing {
    @SerializedName("amount")
    val amount: Int = 0
    @SerializedName("unit")
    val unit: String? = null
}