package com.example.recipe.api.models

import com.example.recipe.domain.models.RecipeInformation
import com.google.gson.annotations.SerializedName

data class RecipeInformationResponse(
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
    var extendedIngredients: List<IngredientResponse>,
    var analyzedInstructions: List<InstructionsResponse>
)

fun RecipeInformationResponse.toRecipeInformation() = RecipeInformation(
    id = id,
    title = title,
    imageUrl = imageUrl,
    servings = servings,
    readyInMinutes = readyInMinutes,
    cheap = cheap,
    glutenFree = glutenFree,
    dairyFree = dairyFree,
    vegan = vegan,
    vegetarian = vegetarian,
    summary = summary,
    instructions = instructions,
    extendedIngredients = extendedIngredients.map { ingredientResponse ->
        ingredientResponse.toIngredient()
    },
    analyzedInstructions = emptyList(),//analyzedInstructions.let { analyzedInstructions[0].toListOfInstructions() }
    isSaved = false
)