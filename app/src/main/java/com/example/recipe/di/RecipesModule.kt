package com.example.recipe.di

import com.example.recipe.api.gateway.RecipeGateway
import com.example.recipe.api.gateway.RecipeGatewayImpl
import com.example.recipe.api.retrofit.RecipeService
import com.example.recipe.domain.usecases.GetRandomRecipe
import com.example.recipe.domain.usecases.GetRandomRecipeImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

//@Module
//@InstallIn(ActivityComponent::class)
//abstract class RecipesModule {
//    @Binds
//    abstract fun gateway(impl: RecipeGatewayImpl): RecipeGateway
//
//    @Binds
//    abstract fun getRandomRecipe(impl: GetRandomRecipeImpl): GetRandomRecipe
//}

@Module
@InstallIn(ActivityComponent::class)
object ManualRecipesModule {
    @Provides
    @Named("BASE_URL")
    fun baseUrl(): String = "https://api.spoonacular.com"

    @Provides
    fun retrofit(@Named("BASE_URL") baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun gateway(service: RecipeService): RecipeGateway {
        return RecipeGatewayImpl(service)
    }

    @Provides
    fun getRandomRecipe(gateway: RecipeGateway): GetRandomRecipe {
        return GetRandomRecipeImpl(gateway)
    }
}