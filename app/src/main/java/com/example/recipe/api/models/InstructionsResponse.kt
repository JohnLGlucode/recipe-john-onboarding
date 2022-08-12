package com.example.recipe.api.models

import com.google.gson.annotations.SerializedName

class InstructionsResponse {
    @SerializedName("steps")
    val steps: List<InstructionStepResponse>? = null
}