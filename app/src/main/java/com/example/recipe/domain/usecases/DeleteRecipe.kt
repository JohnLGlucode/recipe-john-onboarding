package com.example.recipe.domain.usecases

import com.example.recipe.domain.models.Recipe

interface DeleteRecipe {
    suspend fun delete(recipe: Recipe)
}