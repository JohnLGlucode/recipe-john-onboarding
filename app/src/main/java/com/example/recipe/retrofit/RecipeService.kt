package com.example.recipe.retrofit

import com.example.recipe.models.Recipe
import com.example.recipe.retrofit.Responses.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {
    @GET("/recipes/complexSearch")
    fun searchRecipes(@Query("apiKey") apiKey: String, @Query("query") query: String): RecipeSearchResponse

    @GET("/recipes/{id}/information")
    fun getRecipeInformation(@Path("id") id: Int, @Query("apiKey") apiKey: String, @Query("includeNutrition") includeNutrition: Boolean): List<Recipe>

    @GET("/recipes/autocomplete")
    fun getRecipeAutocomplete(@Query("apiKey") apiKey: String, @Query("number") number: Int, @Query("query") query: String): List<Recipe>
}