package com.example.recipe.ui.fragments.saved

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipe.ui.viewDataModels.RecipeViewData
import com.example.recipe.ui.viewDataModels.SavedViewData

class SavedViewModel : ViewModel() {

    val viewData: LiveData<SavedViewData> = MutableLiveData(SavedViewData(mockSavedRecipes))

    private companion object {
        val mockSavedRecipes: List<RecipeViewData> = listOf(
            RecipeViewData(1, "Chicken Soup", "75 min", Uri.parse("https://spoonacular.com/recipeImages/637976-312x231.jpg"), true),
            RecipeViewData(2, "Toasted Grass & Olive Oil", "5 min", Uri.parse("https://spoonacular.com/recipeImages/647876-312x231.jpg"), true),
            RecipeViewData(3, "Rotten Tomato", "50,000 min", Uri.parse("https://spoonacular.com/recipeImages/637276-312x231.jpg"), true),
            RecipeViewData(4, "Pickled Pizza", "25 min", Uri.parse("https://spoonacular.com/recipeImages/637877-312x231.jpg"), true),
            RecipeViewData(5, "Avocado on Bread", "1 min", Uri.parse("https://spoonacular.com/recipeImages/667876-312x231.jpg"), true),
            RecipeViewData(6, "Salted Salt", "0 min", Uri.parse("https://spoonacular.com/recipeImages/638776-312x231.jpg"), true),
            RecipeViewData(7, "Potato Potaato", "69 min", Uri.parse("https://spoonacular.com/recipeImages/673876-312x231.jpg"), true)
        )
    }

}