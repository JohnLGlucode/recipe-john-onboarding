package com.example.recipe.models

import com.google.gson.annotations.SerializedName

class Instructions {
    @SerializedName("steps")
    val steps: List<InstructionStep>? = null
}