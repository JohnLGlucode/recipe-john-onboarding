package com.example.recipe.ui.viewDataModels

import android.net.Uri

data class RecipeViewData(
    val name: String,
    val prepTime: String,
    val image: Uri,
    val isSaved: Boolean
)