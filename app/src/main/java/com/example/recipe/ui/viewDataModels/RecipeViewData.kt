package com.example.recipe.ui.viewDataModels

import android.net.Uri
import android.os.Parcelable
import com.example.recipe.domain.models.Recipe
import kotlinx.parcelize.Parcelize

data class RecipeViewData(
    val id: Int,
    val name: String,
    val prepTime: String,
    val image: Uri,
    val isSaved: Boolean,
    val recipe: Recipe
)

fun Recipe.toViewData() = RecipeViewData(
    id = id,
    name = title,
    prepTime = "$readyInMinutes min",
    image = Uri.parse(imageUrl),
    isSaved = isSaved,
    recipe = this
)