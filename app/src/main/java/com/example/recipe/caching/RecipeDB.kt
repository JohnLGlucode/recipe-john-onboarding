package com.example.recipe.caching

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recipe.caching.dao.SavedRecipeDao
import com.example.recipe.caching.models.RecipeStore

@Database(
    entities = [
        RecipeStore::class
    ],
    version = 1
)
abstract class RecipeDB : RoomDatabase() {
    abstract fun savedRecipeDao(): SavedRecipeDao

    companion object {
        private const val DATABASE_NAME = "recipe-db"

        fun build(context: Context): RecipeDB {
            return Room.databaseBuilder(
                context,
                RecipeDB::class.java, DATABASE_NAME
            ).build()
        }
    }
}