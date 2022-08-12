package com.example.recipe.retrofit

import com.example.recipe.models.Recipe
import com.example.recipe.retrofit.Responses.RandomRecipeResponse
import com.example.recipe.retrofit.Responses.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {
    @GET("/recipes/complexSearch")
    suspend fun searchRecipes(@Query("apiKey") apiKey: String = "98dd4bfc7ddf4feea2e902eff23e1a43", @Query("query") query: String): RecipeSearchResponse

    @GET("/recipes/{id}/information")
    suspend fun getRecipeInformation(@Path("id") id: Int, @Query("apiKey") apiKey: String = "98dd4bfc7ddf4feea2e902eff23e1a43", @Query("includeNutrition") includeNutrition: Boolean): Recipe

    @GET("/recipes/autocomplete")
    suspend fun getRecipeAutocomplete(@Query("apiKey") apiKey: String = "98dd4bfc7ddf4feea2e902eff23e1a43", @Query("number") number: Int, @Query("query") query: String): List<Recipe>

    @GET("/recipes/random")
    suspend fun getRandomRecipe(@Query("apiKey") apiKey: String = "98dd4bfc7ddf4feea2e902eff23e1a43", @Query("number") number: Int): RandomRecipeResponse
}