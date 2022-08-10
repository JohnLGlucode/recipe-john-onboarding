package com.example.recipe.ui.fragments.search

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipe.ui.viewDataModels.RecipeViewData
import com.example.recipe.ui.viewDataModels.SearchViewData

class SearchViewModel : ViewModel() {

    val viewData: LiveData<SearchViewData> = MutableLiveData(SearchViewData(mockSearchResults))

    private companion object {
        val mockSearchResults: List<RecipeViewData> = listOf(
            RecipeViewData("Chicken Soup", "75 min", Uri.parse("https://spoonacular.com/recipeImages/637976-312x231.jpg"), false),
            RecipeViewData("Toasted Grass & Olive Oil", "5 min", Uri.parse("https://spoonacular.com/recipeImages/647876-312x231.jpg"), false),
            RecipeViewData("Rotten Tomato", "50,000 min", Uri.parse("https://spoonacular.com/recipeImages/637276-312x231.jpg"), false),
            RecipeViewData("Pickled Pizza", "25 min", Uri.parse("https://spoonacular.com/recipeImages/637877-312x231.jpg"), false),
            RecipeViewData("Avocado on Bread", "1 min", Uri.parse("https://spoonacular.com/recipeImages/667876-312x231.jpg"), false),
            RecipeViewData("Salted Salt", "0 min", Uri.parse("https://spoonacular.com/recipeImages/638776-312x231.jpg"), false),
            RecipeViewData("Potato Potaato", "69 min", Uri.parse("https://spoonacular.com/recipeImages/673876-312x231.jpg"), false)
        )
    }

}