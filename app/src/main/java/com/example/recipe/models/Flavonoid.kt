package com.example.recipe.models

import com.google.gson.annotations.SerializedName

class Flavonoid {
    @SerializedName("name")
    var name: String? = null
    @SerializedName("amount")
    var amount: Double = 0.0
    @SerializedName("unit")
    var unit: String? = null
}