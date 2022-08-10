package com.example.recipe.ui.viewDataModels

data class IngredientsViewData(
    val aisle: String,
    val image: String,
    val name: String,
    val unit: String,
    val measures: MeasuresViewData
)
