package com.example.recipe.domain.usecases

import com.example.recipe.api.gateway.RecipeGateway
import com.example.recipe.domain.models.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

interface GetRandomRecipe {
    //TODO - Wrap response in Success/Error type
    val randomRecipe: Flow<Recipe>
    suspend operator fun invoke()
}

class GetRandomRecipeImpl @Inject internal constructor(
    private val gateway: RecipeGateway,
    savedRecipesProvider: SavedRecipesProvider
): GetRandomRecipe {
    private val _randomRecipe: MutableStateFlow<Recipe?> = MutableStateFlow(Recipe(
        id = 0,
        title = "Loading...",
        imageUrl = "",
        readyInMinutes = 0,
        isSaved = false
    ))

    override val randomRecipe: Flow<Recipe> = combine(_randomRecipe, savedRecipesProvider.savedRecipes) { randomRecipe, savedRecipes ->
        randomRecipe.let { random ->
            val isSaved = savedRecipes.firstOrNull { random!!.id == it.id } != null
            random!!.copy(isSaved = isSaved)
        }
    }

    override suspend fun invoke() {
        _randomRecipe.value = gateway.getRandomRecipe()
    }
}