package com.example.recipe.ui.viewDataModels

import android.net.Uri

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
    val analyzedInstruction: AnalyzedInstructionsViewData
)
