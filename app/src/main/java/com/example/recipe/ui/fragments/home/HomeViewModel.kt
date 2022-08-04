package com.example.recipe.ui.fragments.home

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val viewData: LiveData<HomeViewData> = MutableLiveData(HomeViewData(mockRecipe))

    private companion object {
        val mockRecipe: RecipeViewData = RecipeViewData(
            name = "Recipe 1",
            prepTime = "1,000 min",
            image =  Uri.parse("https://spoonacular.com/recipeImages/637876-312x231.jpg")
        )
    }

}

data class HomeViewData(
    val recipe: RecipeViewData
)

data class RecipeViewData(
    val name: String,
    val prepTime: String,
    val image: Uri,
)