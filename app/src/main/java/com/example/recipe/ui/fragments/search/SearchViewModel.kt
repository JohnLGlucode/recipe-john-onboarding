package com.example.recipe.ui.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.recipe.domain.models.Recipe
import com.example.recipe.domain.usecases.DeleteRecipe
import com.example.recipe.domain.usecases.SaveRecipe
import com.example.recipe.domain.usecases.SearchRecipe
import com.example.recipe.ui.viewDataModels.RecipeViewData
import com.example.recipe.ui.viewDataModels.SearchViewData
import com.example.recipe.ui.viewDataModels.toViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject internal constructor(
    private val searchRecipes: SearchRecipe,
    private val saveRecipe: SaveRecipe,
    private val deleteRecipe: DeleteRecipe
) : ViewModel() {

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private val _searchResults: Flow<List<Recipe>> = searchRecipes.result

    val viewData: LiveData<SearchViewData> = combine(_isLoading, _searchResults) { isLoading, searchResults ->
        SearchViewData(searchResults.map { it.toViewData() }, isLoading)
    }.asLiveData()

    fun searchRecipes(query: String) = viewModelScope.launch {
        _isLoading.value = true
        searchRecipes.invoke(query)
        _isLoading.value = false
    }

    fun saveOrDelete(viewData: RecipeViewData) = viewModelScope.launch {
        if (viewData.isSaved) {
            deleteRecipe.delete(viewData.recipe)
        } else {
            saveRecipe.save(viewData.recipe)
        }
    }
}