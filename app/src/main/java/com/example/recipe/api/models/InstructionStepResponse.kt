package com.example.recipe.api.models

import com.example.recipe.domain.models.Instructions

data class InstructionStepResponse (
    val number: Int,
    val step: String,
    val ingredients: List<IngredientResponse>,
    val length: LengthResponse?
)

fun InstructionStepResponse.toInstruction() = Instructions(
    number = number,
    step = step,
    ingredients = ingredients.map { ingredient ->
        ingredient.toIngredient()
    },
    length = length?.toLength()
)