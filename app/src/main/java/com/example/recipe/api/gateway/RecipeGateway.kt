package com.example.recipe.api.gateway

import com.example.recipe.api.models.toRecipe
import com.example.recipe.api.retrofit.RecipeService
import com.example.recipe.domain.models.Recipe
import javax.inject.Inject

interface RecipeGateway {
    //TODO - Wrap response in generic "NetworkResponse" type
    suspend fun getRandomRecipe(): Recipe?
}

class RecipeGatewayImpl @Inject internal constructor(
    private val service: RecipeService
): RecipeGateway {
    override suspend fun getRandomRecipe(): Recipe? {
        val response = service.getRandomRecipe(number = 1)
        return response.body()?.randomRecipes?.firstOrNull()?.toRecipe()
    }
}