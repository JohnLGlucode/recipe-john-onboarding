package com.example.recipe.caching.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipe.caching.models.RecipeStore
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedRecipeDao {
    val savedRecipes: Flow<List<RecipeStore>>
        @Query("SELECT * FROM saved_recipes_table ORDER BY id")
        get

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: RecipeStore)

    @Query("DELETE FROM saved_recipes_table WHERE id = :id;")
    suspend fun delete(id: Int)
}