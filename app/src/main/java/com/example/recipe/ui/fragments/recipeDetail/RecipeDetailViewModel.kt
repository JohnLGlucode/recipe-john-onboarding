package com.example.recipe.ui.fragments.recipeDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe.domain.usecases.GetRecipeInformation
import com.example.recipe.ui.viewDataModels.RecipeDetailViewData
import com.example.recipe.ui.viewDataModels.toRecipeDetailModel
import com.example.recipe.ui.viewDataModels.toViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject internal constructor(
    private val getRecipeInformation: GetRecipeInformation
): ViewModel() {

    private val _viewData: MutableLiveData<RecipeDetailViewData> = MutableLiveData(RecipeDetailViewData.loading)
    val viewData: LiveData<RecipeDetailViewData> = _viewData

    fun getRecipeInformation(id: Int) {
        viewModelScope.launch {
            var result = getRecipeInformation.invoke(id)
            result?.let { recipe ->
                _viewData.value = RecipeDetailViewData.success(recipe = recipe.toRecipeDetailModel())
            }
        }
    }

}