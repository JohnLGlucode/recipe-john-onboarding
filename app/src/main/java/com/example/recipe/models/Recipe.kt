package com.example.recipe.models

import com.google.gson.annotations.SerializedName

class Recipe {
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("title")
    var title: String? = null
    @SerializedName("image")
    var imageUrl: String? = null
    @SerializedName("servings")
    var servings: Int = 0
    @SerializedName("readyInMinutes")
    var readyInMinutes: Int = 0
    @SerializedName("aggregateLikes")
    var likes: Int = 0
    @SerializedName("healthScore")
    var healthScore: Double = 0.0
    @SerializedName("pricePerServing")
    var pricePerServing: Double = 0.0
    @SerializedName("cheap")
    var cheap: Boolean = false
    @SerializedName("glutenFree")
    var glutenFree: Boolean = false
    @SerializedName("dairyFree")
    var dairyFree: Boolean = false
    @SerializedName("vegan")
    var vegan: Boolean = false
    @SerializedName("vegetarian")
    var vegetarian: Boolean = false
    @SerializedName("dishTypes")
    var dishTypes: List<String>? = null
    @SerializedName("extendedIngredients")
    var extendedIngredients: List<Ingredient>? = null
}