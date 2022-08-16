package com.example.recipe.ui.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe.domain.usecases.SaveRecipe
import com.example.recipe.domain.usecases.SearchRecipe
import com.example.recipe.ui.viewDataModels.RecipeViewData
import com.example.recipe.ui.viewDataModels.SearchViewData
import com.example.recipe.ui.viewDataModels.toViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject internal constructor(
    private val searchRecipes: SearchRecipe,
    private val saveRecipe: SaveRecipe
) : ViewModel() {

    private val _viewData: MutableLiveData<SearchViewData> = MutableLiveData(SearchViewData.loading)
    val viewData: LiveData<SearchViewData> = _viewData

    fun searchRecipes(query: String) {
        viewModelScope.launch {
            val result = searchRecipes.invoke(query)
            result?.let { recipes ->
                _viewData.value = SearchViewData.success(recipes.map {
                    it.toViewData()
                })
            }
        }
    }

    fun save(viewData: RecipeViewData) = viewModelScope.launch {
        saveRecipe.save(viewData.recipe)
    }
}