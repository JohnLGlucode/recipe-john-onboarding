package com.example.recipe.ui.fragments.recipeDetail

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecipeDetailViewModel : ViewModel() {

    val viewData: LiveData<RecipeDetailViewData> = MutableLiveData(RecipeDetailViewData(mockRecipe))

    companion object {
        val mockRecipe = RecipeDetailModel(
            name = "Salted Salt",
            prepTime = "1,000 min",
            image =  Uri.parse("https://spoonacular.com/recipeImages/637876-312x231.jpg"),
            isSaved = true,
            servings = 4,
            ingredients = listOf(
                IngredientsViewData(
                    aisle = "Spices & Sauces",
                    image = "salt.jpg",
                    name = "Salt",
                    unit = "Tonne",
                    MeasuresViewData(
                        metric = MeasurementViewData(1.5, "Ton's"),
                        us = MeasurementViewData(69.0, "Pounds")
                    )
                )
            ),
            vegetarian = true,
            vegan = true,
            glutenFree = true,
            dairyFree = true,
            cheap = true
        )
    }

}

data class RecipeDetailViewData(
    val recipe: RecipeDetailModel
)

data class RecipeDetailModel(
    val name: String,
    val prepTime: String,
    val image: Uri,
    val isSaved: Boolean,
    val servings: Int,
    val vegetarian: Boolean,
    val vegan: Boolean,
    val glutenFree: Boolean,
    val dairyFree: Boolean,
    val cheap: Boolean,
    val ingredients: List<IngredientsViewData>
)

data class IngredientsViewData(
    val aisle: String,
    val image: String,
    val name: String,
    val unit: String,
    val measures: MeasuresViewData
)

data class MeasuresViewData(
    val metric: MeasurementViewData,
    val us: MeasurementViewData
)

data class MeasurementViewData(
    val amount: Double,
    val unitShort: String
)