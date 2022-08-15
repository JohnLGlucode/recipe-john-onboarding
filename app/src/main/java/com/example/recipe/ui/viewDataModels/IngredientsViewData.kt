package com.example.recipe.ui.viewDataModels

import com.example.recipe.domain.models.Ingredients

data class IngredientsViewData(
    val aisle: String,
    val image: String,
    val name: String,
    val metricMeasurement: String,
    val imperialMeasurement: String
)

fun Ingredients.toViewData() = IngredientsViewData(
    aisle = aisle,
    image = image,
    name = name,
    metricMeasurement = "${metricMeasurements.amount} ${metricMeasurements.unitLong}",
    imperialMeasurement = "${imperialMeasurements.amount} ${imperialMeasurements.unitLong}"
)