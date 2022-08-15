package com.example.recipe.api.models

import com.example.recipe.domain.models.Instructions

data class InstructionsResponse (
    val steps: List<InstructionStepResponse>
)

fun InstructionsResponse.toListOfInstructions(): List<Instructions> {
    return steps.map { step ->
        step.toInstruction()
    }
}