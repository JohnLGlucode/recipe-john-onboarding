package com.example.recipe.domain.usecases

import com.example.recipe.api.gateway.RecipeGateway
import com.example.recipe.domain.models.RecipeInformation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

interface GetRecipeInformation {
    val result: Flow<RecipeInformation>
    suspend operator fun invoke(id: Int)
}

class GetRecipeInformationImpl @Inject internal constructor(
    private val gateway: RecipeGateway,
    savedRecipesProvider: SavedRecipesProvider
): GetRecipeInformation {

    private val _recipeInformation: MutableStateFlow<RecipeInformation> = MutableStateFlow(
        RecipeInformation(
        id = 0,
        title = "Loading...",
        imageUrl = "",
        readyInMinutes = 0,
        cheap = true,
        dairyFree = true,
        glutenFree = true,
        vegan = true,
        vegetarian = true,
        servings = 0,
        instructions = "",
        summary = "",
        analyzedInstructions = emptyList(),
        extendedIngredients = emptyList(),
        isSaved = false
    ))

    override val result: Flow<RecipeInformation> = combine(_recipeInformation, savedRecipesProvider.savedRecipes) { recipeInfo, savedRecipes ->
        recipeInfo.let { recipe ->
            val isSaved = savedRecipes.firstOrNull { recipe.id == it.id } != null
            recipe.copy(isSaved = isSaved)
        }
    }

    override suspend fun invoke(id: Int) {
        _recipeInformation.value = gateway.getRecipeInformation(id)!!
    }

}