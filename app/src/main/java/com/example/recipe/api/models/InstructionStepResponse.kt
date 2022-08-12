package com.example.recipe.api.models

import com.google.gson.annotations.SerializedName

class InstructionStepResponse {
    @SerializedName("number")
    val number: Int = 0
    @SerializedName("step")
    val step: String? = null
    @SerializedName("ingredients")
    val ingredients: List<IngredientResponse>? = null
}