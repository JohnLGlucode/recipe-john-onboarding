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
            cheap = true,
            summary = "this is the summary lol",
            instructions = "instructions will go here one day",
            analyzedInstruction = AnalyzedInstructionsViewData(
                name = "",
                steps = listOf(
                    StepViewData(
                        number = 1,
                        step = "Cook",
                        length = StepLengthViewData(69, "Seconds"),
                        ingredients = listOf(
                            StepIngredientViewData(
                                id = 1,
                                name = "Salt",
                                image = "salt.jpg"
                            ),
                            StepIngredientViewData(
                                id = 2,
                                name = "Sugar",
                                image = "sugar.jpg"
                            )
                        )
                    ),
                    StepViewData(
                        number = 2,
                        step = "Bake",
                        length = StepLengthViewData(420, "Minutes"),
                        ingredients = listOf(
                            StepIngredientViewData(
                                id = 1,
                                name = "Flour",
                                image = "flour.jpg"
                            ),
                            StepIngredientViewData(
                                id = 2,
                                name = "Sugar",
                                image = "sugar.jpg"
                            ),
                            StepIngredientViewData(
                                id = 2,
                                name = "Baking Powder",
                                image = "baking-powder.jpg"
                            )
                        )
                    ),
                    StepViewData(
                        number = 3,
                        step = "Eat",
                        length = StepLengthViewData(1, "Hours"),
                        ingredients = listOf(
                            StepIngredientViewData(
                                id = 1,
                                name = "Cola",
                                image = "cola.jpg"
                            ),
                            StepIngredientViewData(
                                id = 2,
                                name = "Salad",
                                image = "salad.jpg"
                            )
                        )
                    )
                )
            )
        )
    }

}

data class RecipeDetailViewData(
    val recipe: RecipeDetailModel
)

data class RecipeDetailModel(
    val name: String,
    val summary: String,
    val prepTime: String,
    val image: Uri,
    val isSaved: Boolean,
    val servings: Int,
    val vegetarian: Boolean,
    val vegan: Boolean,
    val glutenFree: Boolean,
    val dairyFree: Boolean,
    val cheap: Boolean,
    val ingredients: List<IngredientsViewData>,
    val instructions: String,
    val analyzedInstruction: AnalyzedInstructionsViewData
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

data class AnalyzedInstructionsViewData(
    val name: String,
    val steps: List<StepViewData>
)

data class StepViewData(
    val number: Int,
    val step: String,
    val ingredients: List<StepIngredientViewData>,
    val length: StepLengthViewData
)

data class StepIngredientViewData(
    val id: Int,
    val name: String,
    val image: String
)

data class StepLengthViewData(
    val number: Int,
    val unit: String
)