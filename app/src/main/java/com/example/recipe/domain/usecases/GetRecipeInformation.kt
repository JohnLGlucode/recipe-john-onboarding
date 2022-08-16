package com.example.recipe.domain.usecases

import com.example.recipe.api.gateway.RecipeGateway
import com.example.recipe.domain.models.RecipeInformation
import javax.inject.Inject

interface GetRecipeInformation {
    suspend operator fun invoke(id: Int): RecipeInformation?
}

class GetRecipeInformationImpl @Inject internal constructor(
    private val gateway: RecipeGateway
): GetRecipeInformation {
    override suspend fun invoke(id: Int): RecipeInformation? {
        return gateway.getRecipeInformation(id)
    }

}