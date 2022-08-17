package com.example.recipe.caching

import com.example.recipe.caching.dao.SavedRecipeDao
import com.example.recipe.caching.models.toRecipe
import com.example.recipe.caching.models.toStore
import com.example.recipe.domain.models.Recipe
import com.example.recipe.domain.usecases.DeleteRecipe
import com.example.recipe.domain.usecases.SaveRecipe
import com.example.recipe.domain.usecases.SavedRecipesProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface SavedRecipeCache: SavedRecipesProvider, SaveRecipe, DeleteRecipe

class SavedRecipeCacheImpl @Inject internal constructor(
    private val dao: SavedRecipeDao
): SavedRecipeCache {
    override val savedRecipes: Flow<List<Recipe>> = dao.savedRecipes.map { stores ->
        stores.map { it.toRecipe() }
    }

    override suspend fun save(recipe: Recipe) {
        dao.insert(recipe.toStore())
    }

    override suspend fun delete(recipe: Recipe) {
        dao.delete(recipe.id)
    }
}