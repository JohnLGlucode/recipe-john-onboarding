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

fun Recipe.toViewData(isCached: Boolean = false) = RecipeViewData(
    id = id,
    name = title,
    prepTime = "$readyInMinutes min",
    image = Uri.parse(imageUrl),
    isSaved = when (isCached) {
        true -> true
        false -> false
    },
    recipe = this
)

fun RecipeViewData.toRecipe() = Recipe(
    id = id,
    title = name,
    readyInMinutes = 0,
    imageUrl = image.toString()
)