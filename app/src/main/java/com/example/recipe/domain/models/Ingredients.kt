package com.example.recipe.domain.models

data class Ingredients(
    val aisle: String?,
    val image: String?,
    val name: String,
    val amount: Double,
    val unit: String,
    val metricMeasurements: Measurement?,
    val imperialMeasurements: Measurement?
)