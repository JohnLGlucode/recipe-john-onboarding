package com.example.recipe.ui.viewDataModels

data class HomeViewData(
    val isLoading: Boolean,
    val recipe: RecipeViewData?
) {
    companion object {
        val loading: HomeViewData = HomeViewData(isLoading = true, recipe = null)
        fun success(recipe: RecipeViewData) = HomeViewData(isLoading = false, recipe)
    }
}
