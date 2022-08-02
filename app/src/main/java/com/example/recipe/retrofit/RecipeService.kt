package com.example.recipe.retrofit

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {
    @GET("/recipes/complexSearch")
    fun searchRecipes(@Query("apiKey") apiKey: String, @Query("query") query: String)

    @GET("/recipes/{id}/information")
    fun getRecipeInformation(@Path("id") id: Int, @Query("apiKey") apiKey: String, @Query("includeNutrition") includeNutrition: Boolean)
}