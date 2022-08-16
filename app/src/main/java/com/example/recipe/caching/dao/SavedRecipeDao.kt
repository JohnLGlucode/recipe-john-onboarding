package com.example.recipe.caching.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipe.caching.models.RecipeStore
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedRecipeDao {
    @Query("SELECT * FROM saved_recipes_table ORDER BY id")
    fun getSavedRecipes(): Flow<List<RecipeStore>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recipe: RecipeStore)

    @Query("DELETE FROM saved_recipes_table WHERE id = :id;")
    suspend fun delete(id: Int)
}