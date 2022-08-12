package com.example.recipe.api.gateway

import com.example.recipe.api.models.toRecipe
import com.example.recipe.api.retrofit.RecipeService
import com.example.recipe.domain.models.Recipe
import javax.inject.Inject

interface RecipeGateway {
    //TODO - Wrap response in generic "NetworkResponse" type
    suspend fun getRandomRecipe(): Recipe?
    suspend fun searchRecipes(query: String): List<Recipe>?
}

class RecipeGatewayImpl @Inject internal constructor(
    private val service: RecipeService
): RecipeGateway {
    override suspend fun getRandomRecipe(): Recipe? {
        val response = service.getRandomRecipe(number = 1)
        return response.body()?.randomRecipes?.firstOrNull()?.toRecipe()
    }

    override suspend fun searchRecipes(query: String): List<Recipe>? {
        val response = service.searchRecipes(query = query)
        return response.body()?.recipes?.map {
            it.toRecipe()
        }
    }
}