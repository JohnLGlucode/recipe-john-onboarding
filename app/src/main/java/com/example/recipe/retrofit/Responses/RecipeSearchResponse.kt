package com.example.recipe.retrofit.Responses

import com.example.recipe.models.Recipe
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse {
    @SerializedName("offset")
    var offset: Int = 0
    @SerializedName("number")
    var number: Int = 0
    @SerializedName("totalResults")
    var totalResults: Int = 0
    @SerializedName("results")
    var recipes: List<Recipe>? = null
}