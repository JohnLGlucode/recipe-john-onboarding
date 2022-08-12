package com.example.recipe.domain.models

data class Instructions(
    val number: Int,
    val step: String,
    val ingredients: List<Ingredients>
)