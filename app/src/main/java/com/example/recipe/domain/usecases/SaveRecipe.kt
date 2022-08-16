package com.example.recipe.domain.usecases

import com.example.recipe.domain.models.Recipe

interface SaveRecipe {
    suspend fun save(recipe: Recipe)
}