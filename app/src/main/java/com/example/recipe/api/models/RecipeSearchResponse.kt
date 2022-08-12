package com.example.recipe.api.models

import com.google.gson.annotations.SerializedName

class RecipeSearchResponse {
    @SerializedName("offset")
    var offset: Int = 0
    @SerializedName("number")
    var number: Int = 0
    @SerializedName("totalResults")
    var totalResults: Int = 0
    @SerializedName("results")
    var recipes: List<RecipeResponse>? = null
}