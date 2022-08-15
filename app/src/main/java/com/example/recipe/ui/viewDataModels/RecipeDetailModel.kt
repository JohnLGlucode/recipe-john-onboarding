package com.example.recipe.ui.viewDataModels

import android.net.Uri
import com.example.recipe.domain.models.Recipe

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

fun Recipe.toRecipeDetailModel() = RecipeDetailModel(
    name = title,
    summary = summary!!,
    prepTime = "$readyInMinutes min",
    image = Uri.parse(imageUrl),
    isSaved = false,
    servings = servings!!,
    vegetarian = when (vegetarian) {
        true -> "Yes"
        false -> "No"
        else -> {
            "No"
        }
    },
    vegan = when (vegan) {
        true -> "Yes"
        false -> "No"
        else -> {
            "No"
        }
    },
    glutenFree = when (glutenFree) {
        true -> "Yes"
        false -> "No"
        else -> {
            "No"
        }
    },
    dairyFree = when (dairyFree) {
        true -> "Yes"
        false -> "No"
        else -> {
            "No"
        }
    },
    cheap = when (cheap) {
        true -> "Yes"
        false -> "No"
        else -> {
            "no"
        }
    },
    ingredients = extendedIngredients.map { ingredients ->
        ingredients.toViewData()
    },
    instructions = instructions!!,
    instructionSteps = analyzedInstructions.map { instructions ->
        instructions.toStepViewData()
    }
)