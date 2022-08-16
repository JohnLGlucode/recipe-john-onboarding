package com.example.recipe.api.models

import com.example.recipe.domain.models.Ingredients

data class IngredientResponse(
    val aisle: String?,
    var image: String,
    var measures: MeasurementsResponse?,
    var name: String,
    var amount: Double,
    var unit: String,
    var nutrients: List<NutrientResponse>?
)

fun IngredientResponse.toIngredient() = Ingredients(
    aisle = aisle,
    image = image,
    name = name,
    amount = amount,
    unit = unit,
    metricMeasurements = measures?.let { measures?.metric!!.toMeasurement() },
    imperialMeasurements = measures?.let { measures?.us!!.toMeasurement() }
)