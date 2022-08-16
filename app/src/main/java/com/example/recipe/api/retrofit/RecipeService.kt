package com.example.recipe.api.retrofit

import com.example.recipe.api.models.RecipeResponse
import com.example.recipe.api.models.RandomRecipeResponse
import com.example.recipe.api.models.RecipeInformationResponse
import com.example.recipe.api.models.RecipeSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {
    @GET("/recipes/complexSearch")
    suspend fun searchRecipes(@Query("apiKey") apiKey: String = "98dd4bfc7ddf4feea2e902eff23e1a43", @Query("query") query: String, @Query("addRecipeInformation") addRecipeInformation: Boolean = true): Response<RecipeSearchResponse>

    @GET("/recipes/{id}/information")
    suspend fun getRecipeInformation(@Path("id") id: Int, @Query("apiKey") apiKey: String = "98dd4bfc7ddf4feea2e902eff23e1a43", @Query("includeNutrition") includeNutrition: Boolean = true): Response<RecipeInformationResponse>

    @GET("/recipes/autocomplete")
    suspend fun getRecipeAutocomplete(@Query("apiKey") apiKey: String = "98dd4bfc7ddf4feea2e902eff23e1a43", @Query("number") number: Int, @Query("query") query: String): Response<List<RecipeResponse>>

    @GET("/recipes/random")
    suspend fun getRandomRecipe(@Query("apiKey") apiKey: String = "98dd4bfc7ddf4feea2e902eff23e1a43", @Query("number") number: Int): Response<RandomRecipeResponse?>
}