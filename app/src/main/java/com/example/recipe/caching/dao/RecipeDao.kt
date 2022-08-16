package com.example.recipe.caching.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipe.caching.models.RecipeDB

@Dao
interface RecipeDao {
    @Query("SELECT * FROM saved_recipes_table ORDER BY id")
    fun getSavedRecipes(): List<RecipeDB>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recipe: RecipeDB)

    @Query("DELETE FROM saved_recipes_table WHERE id = :id;")
    suspend fun delete(id: Int)
}