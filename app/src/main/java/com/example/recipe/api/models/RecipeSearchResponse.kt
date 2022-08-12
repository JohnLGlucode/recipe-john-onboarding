package com.example.recipe.api.models

import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse (
    var offset: Int,
    var number: Int,
    var totalResults: Int,
    @SerializedName("results")
    var recipes: List<RecipeResponse>
)