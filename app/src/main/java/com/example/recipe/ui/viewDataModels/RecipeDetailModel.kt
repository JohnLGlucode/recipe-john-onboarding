package com.example.recipe.ui.viewDataModels

import android.net.Uri
import com.example.recipe.domain.models.Recipe
import com.example.recipe.domain.models.RecipeInformation

data class RecipeDetailModel(
    val id: Int,
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
    val instructionSteps: List<StepViewData>,
    val recipe: Recipe
)

fun RecipeDetailModel.toRecipe() = Recipe(
    id = recipe.id,
    title = recipe.title,
    imageUrl = recipe.imageUrl,
    readyInMinutes = recipe.readyInMinutes,
    isSaved = true
)

fun RecipeInformation.toRecipeDetailModel() = RecipeDetailModel(
    id = id,
    name = title,
    summary = summary,
    prepTime = "$readyInMinutes min",
    image = Uri.parse(imageUrl),
    isSaved = isSaved,
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
    },
    recipe = Recipe(id, title, imageUrl, readyInMinutes, false)
)