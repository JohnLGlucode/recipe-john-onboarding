package com.example.recipe.ui.viewDataModels

import android.net.Uri
import com.example.recipe.domain.models.RecipeInformation

data class RecipeDetailModel(
    val name: String,
    val summary: String,
    val prepTime: String,
    val image: Uri,
    val isSaved: Boolean,
    val servings: Int,
    val vegetarian: String,
    val vegan: String,
    val glutenFree: String,
    val dairyFree: String,
    val cheap: String,
    val ingredients: List<IngredientsViewData>,
    val instructions: String,
    val instructionSteps: List<StepViewData>
)

fun RecipeInformation.toRecipeDetailModel() = RecipeDetailModel(
    name = title,
    summary = summary,
    prepTime = "$readyInMinutes min",
    image = Uri.parse(imageUrl),
    isSaved = false,
    servings = servings,
    vegetarian = when (vegetarian) {
        true -> "Yes"
        false -> "No"
    },
    vegan = when (vegan) {
        true -> "Yes"
        false -> "No"
    },
    glutenFree = when (glutenFree) {
        true -> "Yes"
        false -> "No"
    },
    dairyFree = when (dairyFree) {
        true -> "Yes"
        false -> "No"
    },
    cheap = when (cheap) {
        true -> "Yes"
        false -> "No"
    },
    ingredients = extendedIngredients.map { ingredients ->
        ingredients.toViewData()
    },
    instructions = instructions,
    instructionSteps = analyzedInstructions.map { instructions ->
        instructions.toStepViewData()
    }
)