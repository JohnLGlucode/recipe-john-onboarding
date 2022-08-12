package com.example.recipe.api.models

import android.net.Uri
import com.example.recipe.domain.models.Recipe
import com.example.recipe.ui.viewDataModels.RecipeViewData
import com.google.gson.annotations.SerializedName

data class RecipeResponse (
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
//    var extendedIngredients: List<IngredientResponse>,
//    var analyzedInstructions: InstructionsResponse
)

fun RecipeResponse.toRecipe() = Recipe(
    id = id,
    title = title,
    imageUrl = imageUrl,
    servings = servings,
    readyInMinutes = readyInMinutes,
    cheap = cheap,
    glutenFree = glutenFree,
    dairyFree = dairyFree,
    vegan = vegan,
    vegetarian =vegetarian,
    summary = summary,
    instructions = instructions
)

fun RecipeResponse.toRecipeViewData(): RecipeViewData {

    val ingredients1 = IngredientResponse("aisle1")
    val ingredients2 = IngredientResponse("aisle1")
    (ingredients1 == ingredients2)

    return RecipeViewData(
        name = title,
        image = Uri.parse(imageUrl),
        prepTime = "$readyInMinutes Minutes",
        isSaved = false
    )
}