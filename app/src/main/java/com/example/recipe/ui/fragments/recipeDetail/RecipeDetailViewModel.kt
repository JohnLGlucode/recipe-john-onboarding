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
                        metric = "1.5 Tonnes",
                        imperial = "69 Pounds"
                    )
                ),
                IngredientsViewData(
                    aisle = "Baking",
                    image = "sugar.jpg",
                    name = "Sugar",
                    unit = "Grams",
                    MeasuresViewData(
                        metric = "110.5 Grams",
                        imperial = "9 Stone"
                    )
                ),
                IngredientsViewData(
                    aisle = "Butchery",
                    image = "mince-meat.jpg",
                    name = "Mince Meat",
                    unit = "Kilogram",
                    MeasuresViewData(
                        metric = "2 Kilogram",
                        imperial = "13 Feet"
                    )
                ),
                IngredientsViewData(
                    aisle = "Snacks & Candy",
                    image = "candy-floss.jpg",
                    name = "Candy Floss",
                    unit = "Kilogram",
                    MeasuresViewData(
                        metric = "11 Kilogram",
                        imperial = "197 Feet"
                    )
                ),
                IngredientsViewData(
                    aisle = "Condiments",
                    image = "tomato-sauce.jpg",
                    name = "Tomato Sauce",
                    unit = "Mili-liters",
                    MeasuresViewData(
                        metric = "500 ML",
                        imperial = "123 Ounces"
                    )
                )
            ),
            vegetarian = "Yes",
            vegan = "No",
            glutenFree = "Yes",
            dairyFree = "No",
            cheap = "Yes",
            summary = "this is the summary lol",
            instructions = "instructions will go here one day xx",
            analyzedInstruction = AnalyzedInstructionsViewData(
                name = "",
                steps = listOf(
                    StepViewData(
                        number = 1,
                        step = "Cook",
                        length = "69 Seconds",
                        ingredients = "Sugar, Salt & Eggs"
                    ),
                    StepViewData(
                        number = 2,
                        step = "Bake",
                        length = "420 Minutes",
                        ingredients = "Baking Powder, Rice, Coke & More Salt"
                    ),
                    StepViewData(
                        number = 3,
                        step = "Eat",
                        length = "1 Hours",
                        ingredients = "Bread, Water, Vodka & Tequila"
                    ),
                    StepViewData(
                        number = 420,
                        step = "Eat a Lot of Junk Food XD",
                        length = "30 Minutes",
                        ingredients = "Doritos, Wine Gums, Popcorn, Hotdogs & Wings"
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
    val vegetarian: String,
    val vegan: String,
    val glutenFree: String,
    val dairyFree: String,
    val cheap: String,
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
    val metric: String,
    val imperial: String
)

data class AnalyzedInstructionsViewData(
    val name: String,
    val steps: List<StepViewData>
)

data class StepViewData(
    val number: Int,
    val step: String,
    val ingredients: String,
    val length: String
)