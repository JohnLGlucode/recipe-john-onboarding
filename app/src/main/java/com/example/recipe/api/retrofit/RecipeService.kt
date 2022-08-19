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
    suspend fun searchRecipes(
        @Query("apiKey") apiKey: String = "98dd4bfc7ddf4feea2e902eff23e1a43",
        @Query("query") query: String,
        @Query("addRecipeInformation") addRecipeInformation: Boolean = true,
        @Query("cuisine") cuisine: String? = null,
        @Query("diet") diet: String? = null,
        @Query("intolerances") intolerances: String? = null,
        @Query("type") mealType: String? = null,
        @Query("maxReadyTime") maxReadyTime: Int? = null,
        @Query("minCaffeine") minCaffeine: Int? = null,
        @Query("maxCaffeine") maxCaffeine: Int? = null,
        @Query("minCalcium") minCalcium: Int? = null,
        @Query("maxCalcium") maxCalcium: Int? = null,
        @Query("minCarbs") minCarbs: Int? = null,
        @Query("maxCarbs") maxCarbs: Int? = null,
        @Query("minCholesterol") minCholesterol: Int? = null,
        @Query("maxCholesterol") maxCholesterol: Int? = null,
        @Query("minFat") minFat: Int? = null,
        @Query("maxFat") maxFat: Int? = null,
        @Query("minFiber") minFiber: Int? = null,
        @Query("maxFiber") maxFiber: Int? = null,
        @Query("minIron") minIron: Int? = null,
        @Query("maxIron") maxIron: Int? = null,
        @Query("minProtein") minProtein: Int? = null,
        @Query("maxProtein") maxProtein: Int? = null,
        @Query("minSaturatedFat") minSaturatedFat: Int? = null,
        @Query("maxSaturatedFat") maxSaturatedFat: Int? = null,
        @Query("minSodium") minSodium: Int? = null,
        @Query("maxSodium") maxSodium: Int? = null,
        @Query("minSugar") minSugar: Int? = null,
        @Query("maxSugar") maxSugar: Int? = null,
        @Query("minZinc") minZinc: Int? = null,
        @Query("maxZinc") maxZinc: Int? = null
    ): Response<RecipeSearchResponse>

    @GET("/recipes/{id}/information")
    suspend fun getRecipeInformation(@Path("id") id: Int, @Query("apiKey") apiKey: String = "98dd4bfc7ddf4feea2e902eff23e1a43", @Query("includeNutrition") includeNutrition: Boolean = true): Response<RecipeInformationResponse>

    @GET("/recipes/autocomplete")
    suspend fun getRecipeAutocomplete(@Query("apiKey") apiKey: String = "98dd4bfc7ddf4feea2e902eff23e1a43", @Query("number") number: Int, @Query("query") query: String): Response<List<RecipeResponse>>

    @GET("/recipes/random")
    suspend fun getRandomRecipe(@Query("apiKey") apiKey: String = "98dd4bfc7ddf4feea2e902eff23e1a43", @Query("number") number: Int): Response<RandomRecipeResponse?>
}