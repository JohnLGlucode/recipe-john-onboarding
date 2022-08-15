package com.example.recipe.api.models

import com.example.recipe.domain.models.Length

data class LengthResponse(
    val number: Int,
    val unit: String
)

fun LengthResponse.toLength() = Length(
    number = number,
    unit = unit
)