package com.example.recipe.api.models

import com.google.gson.annotations.SerializedName

class RandomRecipeResponse {
    @SerializedName("recipes")
    var randomRecipes: List<RecipeResponse>? = null
}