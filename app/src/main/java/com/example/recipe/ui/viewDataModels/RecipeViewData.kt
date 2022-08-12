package com.example.recipe.ui.viewDataModels

import android.net.Uri
import com.example.recipe.domain.models.Recipe

data class RecipeViewData(
    val name: String,
    val prepTime: String,
    val image: Uri,
    val isSaved: Boolean
)

fun Recipe.toViewData() = RecipeViewData(
    name = title,
    prepTime = "$readyInMinutes min",
    image = Uri.parse(imageUrl),
    isSaved = false //TODO
)