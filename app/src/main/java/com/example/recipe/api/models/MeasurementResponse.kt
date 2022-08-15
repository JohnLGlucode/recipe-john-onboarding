package com.example.recipe.api.models

import com.example.recipe.domain.models.Measurement

data class MeasurementResponse (
    var amount: Double,
    var unitLong: String,
    var unitShort: String
)

fun MeasurementResponse.toMeasurement() = Measurement(
    amount = amount,
    unitLong = unitLong,
    unitShort = unitShort
)