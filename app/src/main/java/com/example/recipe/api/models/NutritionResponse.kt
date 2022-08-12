package com.example.recipe.api.models

import com.google.gson.annotations.SerializedName

class NutritionResponse {
    @SerializedName("nutrients")
    val nutrients: List<NutrientResponse>? = null
    @SerializedName("properties")
    val properties: List<PropertyResponse>? = null
    @SerializedName("flavonoids")
    val flavonoids: List<FlavonoidResponse>? = null
    @SerializedName("ingredients")
    val ingredients: List<IngredientResponse>? = null
    @SerializedName("caloricBreakdown")
    val caloricBreakdown: CaloricBreakdownResponse? = null
    @SerializedName("weightPerServing")
    val weightPerServing: WeightPerServingResponse? = null
}