package com.example.recipe.ui.search

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    val viewData: LiveData<SearchViewData> = MutableLiveData(SearchViewData(mockSearchResults))

    private companion object {
        val mockSearchResults: List<SearchRecipeViewData> = listOf(
            SearchRecipeViewData("Chicken Soup", "75 min", Uri.parse("https://spoonacular.com/recipeImages/637976-312x231.jpg")),
            SearchRecipeViewData("Toasted Grass & Olive Oil", "5 min", Uri.parse("https://spoonacular.com/recipeImages/647876-312x231.jpg")),
            SearchRecipeViewData("Rotten Tomato", "50,000 min", Uri.parse("https://spoonacular.com/recipeImages/637276-312x231.jpg")),
            SearchRecipeViewData("Pickled Pizza", "25 min", Uri.parse("https://spoonacular.com/recipeImages/637877-312x231.jpg")),
            SearchRecipeViewData("Avocado on Bread", "1 min", Uri.parse("https://spoonacular.com/recipeImages/667876-312x231.jpg")),
            SearchRecipeViewData("Salted Salt", "0 min", Uri.parse("https://spoonacular.com/recipeImages/638776-312x231.jpg")),
            SearchRecipeViewData("Potato Potaato", "69 min", Uri.parse("https://spoonacular.com/recipeImages/673876-312x231.jpg"))
        )
    }

}

data class SearchViewData(
    val searchRecipes: List<SearchRecipeViewData>
)

data class SearchRecipeViewData(
    val name: String,
    val prepTime: String,
    val image: Uri,
)