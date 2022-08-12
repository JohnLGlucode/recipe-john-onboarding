package com.example.recipe.domain.usecases

import com.example.recipe.api.gateway.RecipeGateway
import com.example.recipe.domain.models.Recipe
import javax.inject.Inject

interface GetRandomRecipe {
    //TODO - Wrap response in Success/Error type
    suspend operator fun invoke(): Recipe?
}

class GetRandomRecipeImpl @Inject internal constructor(
    private val gateway: RecipeGateway
): GetRandomRecipe {
    override suspend fun invoke(): Recipe? {
        return gateway.getRandomRecipe()
    }
}