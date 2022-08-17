package com.example.recipe.domain.usecases

import com.example.recipe.api.gateway.RecipeGateway
import com.example.recipe.domain.models.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

interface SearchRecipe {
    val result: Flow<List<Recipe>>
    suspend operator fun invoke(query: String)
}

class SearchRecipeImpl @Inject internal constructor(
    private val gateway: RecipeGateway,
    savedRecipesProvider: SavedRecipesProvider
): SearchRecipe {
    private val _result: MutableStateFlow<List<Recipe>> = MutableStateFlow(emptyList())

    override val result: Flow<List<Recipe>> = combine(_result, savedRecipesProvider.savedRecipes) { searchResults, savedRecipes ->
        searchResults.map { recipe ->
            val isSaved = savedRecipes.firstOrNull { recipe.id == it.id } != null
            recipe.copy(isSaved = isSaved)
        }
    }

    override suspend fun invoke(query: String) {
        _result.value = gateway.searchRecipes(query) ?: emptyList()
    }
}