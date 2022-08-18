package com.example.recipe.ui.fragments.recipeDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.recipe.domain.models.RecipeInformation
import com.example.recipe.domain.usecases.DeleteRecipe
import com.example.recipe.domain.usecases.GetRecipeInformation
import com.example.recipe.domain.usecases.SaveRecipe
import com.example.recipe.ui.viewDataModels.RecipeDetailViewData
import com.example.recipe.ui.viewDataModels.toRecipe
import com.example.recipe.ui.viewDataModels.toRecipeDetailModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject internal constructor(
    private val getRecipeInformation: GetRecipeInformation,
    private val saveRecipe: SaveRecipe,
    private val deleteRecipe: DeleteRecipe
): ViewModel() {

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private val _recipeDetail: Flow<RecipeInformation> = getRecipeInformation.result

    val viewData: LiveData<RecipeDetailViewData> = combine(_isLoading, _recipeDetail) { isLoading, recipe ->
        RecipeDetailViewData(isLoading = isLoading, recipe = recipe.toRecipeDetailModel())
    }.asLiveData()

    fun getRecipeInformation(id: Int) = viewModelScope.launch {
        _isLoading.value = true
        getRecipeInformation.invoke(id)
        _isLoading.value = false
    }

    fun saveOrDelete(viewData: RecipeDetailViewData) = viewModelScope.launch {
        if (viewData.recipe!!.isSaved) {
            deleteRecipe.delete(viewData.recipe.toRecipe())
        } else {
            saveRecipe.save(viewData.recipe.toRecipe())
        }
    }

}