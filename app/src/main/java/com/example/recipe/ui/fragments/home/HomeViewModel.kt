package com.example.recipe.ui.fragments.home

import androidx.lifecycle.*
import com.example.recipe.domain.models.Recipe
import com.example.recipe.domain.usecases.DeleteRecipe
import com.example.recipe.domain.usecases.GetRandomRecipe
import com.example.recipe.domain.usecases.SaveRecipe
import com.example.recipe.ui.viewDataModels.HomeViewData
import com.example.recipe.ui.viewDataModels.RecipeViewData
import com.example.recipe.ui.viewDataModels.toViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject internal constructor(
    private val getRandomRecipe: GetRandomRecipe,
    private val saveRecipe: SaveRecipe,
    private val deleteRecipe: DeleteRecipe
) : ViewModel() {

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private val _randomRecipeResult: Flow<Recipe> = getRandomRecipe.randomRecipe

    val viewData: LiveData<HomeViewData> = combine(_isLoading, _randomRecipeResult) { isLoading, randomRecipe ->
        HomeViewData(isLoading, randomRecipe.toViewData())
    }.asLiveData()

    init {
        viewModelScope.launch {
            _isLoading.value = true
            getRandomRecipe.invoke()
            _isLoading.value = false
        }
    }

    fun saveOrDeleteRecipe(viewData: RecipeViewData) = viewModelScope.launch {
        if (viewData.isSaved) {
            deleteRecipe.delete(viewData.recipe)
        } else {
            saveRecipe.save(viewData.recipe)
        }
    }
}