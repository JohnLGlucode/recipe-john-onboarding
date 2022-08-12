package com.example.recipe.ui.viewDataModels

data class SearchViewData(
    val searchRecipes: List<RecipeViewData>?,
    val isLoading: Boolean
) {
    companion object {
        val loading: SearchViewData = SearchViewData(isLoading = true, searchRecipes = null)
        fun success(recipes: List<RecipeViewData>) = SearchViewData(isLoading = false, searchRecipes = recipes)
    }
}
