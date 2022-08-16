package com.example.recipe.api.models

import com.example.recipe.domain.models.Recipe
import com.google.gson.annotations.SerializedName

data class RecipeResponse (
    var id: Int,
    var title: String,
    @SerializedName("image")
    var imageUrl: String,
    var readyInMinutes: Int?
)

fun RecipeResponse.toRecipe() = Recipe(
    id = id,
    title = title,
    imageUrl = imageUrl,
    readyInMinutes = readyInMinutes
)