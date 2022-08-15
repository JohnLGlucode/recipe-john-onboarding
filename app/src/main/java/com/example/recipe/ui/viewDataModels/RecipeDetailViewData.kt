package com.example.recipe.ui.viewDataModels

data class RecipeDetailViewData(
    val recipe: RecipeDetailModel?,
    val isLoading: Boolean
) {
    companion object {
        val loading: RecipeDetailViewData = RecipeDetailViewData(isLoading = true, recipe = null)
        fun success(recipe: RecipeDetailModel?) = RecipeDetailViewData(isLoading = false, recipe = recipe)
    }
}
