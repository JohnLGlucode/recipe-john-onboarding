package com.example.recipe.retrofit.Responses

import com.example.recipe.models.Recipe
import com.google.gson.annotations.SerializedName

class RandomRecipeResponse {
    @SerializedName("recipes")
    var randomRecipes: List<Recipe>? = null
}