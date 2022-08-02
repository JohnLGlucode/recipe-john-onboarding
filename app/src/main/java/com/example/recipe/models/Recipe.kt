package com.example.recipe.models

import com.google.gson.annotations.SerializedName

class Recipe {
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("title")
    var title: String? = null
    @SerializedName("image")
    var imageUrl: String? = null
    var servings: Int = 0
    var readyInMinutes: Int = 0
    var likes: Int = 0
    var healthScore: Double = 0.0
    var pricePerServing: Double = 0.0
    var cheap: Boolean = false
    var glutenFree: Boolean = false
}