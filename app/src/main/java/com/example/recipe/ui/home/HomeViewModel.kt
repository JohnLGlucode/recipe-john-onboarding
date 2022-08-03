package com.example.recipe.ui.home

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipe.models.Recipe

class HomeViewModel : ViewModel() {

    val viewData: LiveData<HomeViewData> = MutableLiveData(HomeViewData(mockRecipe))

    private companion object {
        val mockRecipe: RecipeViewData = RecipeViewData(
            name = "Recipe 1",
            prepTime = "1,000 min",
            image =  Uri.parse("www.asdasdasdasd")
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