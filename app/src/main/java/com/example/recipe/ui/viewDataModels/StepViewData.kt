package com.example.recipe.ui.viewDataModels

import com.example.recipe.domain.models.Instructions

data class StepViewData(
    val number: Int,
    val step: String,
    val ingredients: String,
    val length: String
)

fun Instructions.toStepViewData() = StepViewData(
    number = number,
    step = step,
    length = "${length?.number} ${length?.unit}",
    ingredients = ingredients.joinToString(separator = " - ") {
        it.name
    }
)