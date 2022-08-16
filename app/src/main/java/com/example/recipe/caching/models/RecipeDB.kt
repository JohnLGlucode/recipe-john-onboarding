package com.example.recipe.caching.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_recipes_table")
data class RecipeDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val recipeId: Int,
    val title: String,
    val imageUrl: String,
    val readyInMinutes: Int?
)
