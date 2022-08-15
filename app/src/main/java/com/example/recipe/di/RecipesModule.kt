package com.example.recipe.di

import com.example.recipe.api.gateway.RecipeGateway
import com.example.recipe.api.gateway.RecipeGatewayImpl
import com.example.recipe.api.retrofit.RecipeService
import com.example.recipe.domain.usecases.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
abstract class RecipesModule {
    @Binds
    abstract fun gateway(impl: RecipeGatewayImpl): RecipeGateway

    @Binds
    abstract fun getRandomRecipe(impl: GetRandomRecipeImpl): GetRandomRecipe

    @Binds
    abstract fun searchRecipes(impl: SearchRecipeImpl): SearchRecipe

    @Binds
    abstract fun getRecipeInformation(impl: GetRecipeInformationImpl): GetRecipeInformation
}

@Module
@InstallIn(SingletonComponent::class)
object ManualRecipesModule {
    @Provides
    @Named("BASE_URL")
    fun baseUrl(): String = "https://api.spoonacular.com"

    @Provides
    fun retrofit(@Named("BASE_URL") baseUrl: String): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun recipesService(retrofit: Retrofit): RecipeService {
        return retrofit.create(RecipeService::class.java)
    }
}