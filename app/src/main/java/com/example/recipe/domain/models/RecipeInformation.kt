package com.example.recipe.domain.models

data class RecipeInformation(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val servings: Int,
    val readyInMinutes: Int,
    val cheap: Boolean,
    val glutenFree: Boolean,
    val dairyFree: Boolean,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val summary: String,
    val instructions: String,
    val extendedIngredients: List<Ingredients>,
    val analyzedInstructions: List<Instructions>,
    val isSaved: Boolean
)
