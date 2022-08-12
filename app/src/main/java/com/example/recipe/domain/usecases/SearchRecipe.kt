package com.example.recipe.domain.usecases

import com.example.recipe.api.gateway.RecipeGateway
import com.example.recipe.domain.models.Recipe
import javax.inject.Inject

interface SearchRecipe {
    suspend operator fun invoke(query: String): List<Recipe>?
}

class SearchRecipeImpl @Inject internal constructor(
    private val gateway: RecipeGateway
): SearchRecipe {
    override suspend fun invoke(query: String): List<Recipe>? {
        return gateway.searchRecipes(query)
    }

}