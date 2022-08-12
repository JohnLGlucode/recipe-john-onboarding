package com.example.recipe.api.models

import com.google.gson.annotations.SerializedName

data class IngredientResponse(
    @SerializedName("aisle")
    val aisle: String? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("measures")
    var measures: MeasurementsResponse? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("amount")
    var amount: Double = 0.0,
    @SerializedName("unit")
    var unit: String? = null,
    @SerializedName("nutrients")
    var nutrients: List<NutrientResponse>? = null
)