package com.example.recipe.models

import com.google.gson.annotations.SerializedName

class InstructionStep {
    @SerializedName("number")
    val number: Int = 0
    @SerializedName("step")
    val step: String? = null
    @SerializedName("ingredients")
    val ingredients: List<Ingredient>? = null
}