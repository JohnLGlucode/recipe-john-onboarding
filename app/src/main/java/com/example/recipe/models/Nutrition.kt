package com.example.recipe.models

import com.google.gson.annotations.SerializedName

class Nutrition {
    @SerializedName("nutrients")
    val nutrients: List<Nutrient>? = null
    @SerializedName("properties")
    val properties: List<Property>? = null
    @SerializedName("flavonoids")
    val flavonoids: List<Flavonoid>? = null
    @SerializedName("ingredients")
    val ingredients: List<Ingredient>? = null
    @SerializedName("caloricBreakdown")
    val caloricBreakdown: CaloricBreakdown? = null
    @SerializedName("weightPerServing")
    val weightPerServing: WeightPerServing? = null
}