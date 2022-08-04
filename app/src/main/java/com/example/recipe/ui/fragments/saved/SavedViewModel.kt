package com.example.recipe.ui.fragments.saved

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SavedViewModel : ViewModel() {

    val viewData: LiveData<SavedViewData> = MutableLiveData(SavedViewData(mockSavedRecipes))

    private companion object {
        val mockSavedRecipes: List<RecipeViewData> = listOf(
            RecipeViewData("Chicken Soup", "75 min", Uri.parse("https://spoonacular.com/recipeImages/637976-312x231.jpg"), true),
            RecipeViewData("Toasted Grass & Olive Oil", "5 min", Uri.parse("https://spoonacular.com/recipeImages/647876-312x231.jpg"), true),
            RecipeViewData("Rotten Tomato", "50,000 min", Uri.parse("https://spoonacular.com/recipeImages/637276-312x231.jpg"), true),
            RecipeViewData("Pickled Pizza", "25 min", Uri.parse("https://spoonacular.com/recipeImages/637877-312x231.jpg"), true),
            RecipeViewData("Avocado on Bread", "1 min", Uri.parse("https://spoonacular.com/recipeImages/667876-312x231.jpg"), true),
            RecipeViewData("Salted Salt", "0 min", Uri.parse("https://spoonacular.com/recipeImages/638776-312x231.jpg"), true),
            RecipeViewData("Potato Potaato", "69 min", Uri.parse("https://spoonacular.com/recipeImages/673876-312x231.jpg"), true)
        )
    }

}

data class SavedViewData(
    val searchRecipes: List<RecipeViewData>
)

data class RecipeViewData(
    val name: String,
    val prepTime: String,
    val image: Uri,
    val isSaved: Boolean
)