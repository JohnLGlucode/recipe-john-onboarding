package com.example.recipe.domain.usecases

import com.example.recipe.domain.models.Recipe
import kotlinx.coroutines.flow.Flow

interface SavedRecipesProvider {
    val savedRecipes: Flow<List<Recipe>>
}