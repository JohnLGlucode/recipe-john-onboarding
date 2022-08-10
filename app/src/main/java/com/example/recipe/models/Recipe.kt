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
    @SerializedName("summary")
    var summary: String? = null
    @SerializedName("instructions")
    var instructions: String? = null
    @SerializedName("extendedIngredients")
    var extendedIngredients: List<Ingredient>? = null
    @SerializedName("analyzedInstructions")
    var analyzedInstructions: Instructions? = null
}