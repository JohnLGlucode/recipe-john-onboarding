package com.example.recipe.models

import android.net.Uri
import com.example.recipe.ui.viewDataModels.RecipeViewData
import com.google.gson.annotations.SerializedName

data class Recipe (
    var id: Int,
    var title: String,
    @SerializedName("image")
    var imageUrl: String,
    var servings: Int,
    var readyInMinutes: Int,
    var cheap: Boolean,
    var glutenFree: Boolean,
    var dairyFree: Boolean,
    var vegan: Boolean,
    var vegetarian: Boolean,
    var summary: String,
    var instructions: String,
    var extendedIngredients: List<Ingredient>,
    var analyzedInstructions: Instructions
)

fun Recipe.toRecipeViewData(): RecipeViewData {
    return RecipeViewData(
        name = title,
        image = Uri.parse(imageUrl),
        prepTime = "$readyInMinutes Minutes",
        isSaved = false
    )
}