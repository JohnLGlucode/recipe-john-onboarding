package com.example.recipe.caching.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recipe.domain.models.Recipe

@Entity(tableName = "saved_recipes_table")
data class RecipeStore(
    @PrimaryKey
    val id: Int,
    val title: String,
    val imageUrl: String,
    val readyInMinutes: Int?
)

fun RecipeStore.toRecipe() = Recipe(
    id = id,
    title = title,
    imageUrl = imageUrl,
    readyInMinutes = readyInMinutes
)

fun Recipe.toStore(): RecipeStore = RecipeStore(
    id = id,
    title = title,
    imageUrl = imageUrl!!,
    readyInMinutes = readyInMinutes
)
