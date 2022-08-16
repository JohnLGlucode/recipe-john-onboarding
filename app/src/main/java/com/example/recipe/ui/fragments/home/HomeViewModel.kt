package com.example.recipe.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe.ui.viewDataModels.HomeViewData
import com.example.recipe.ui.viewDataModels.toViewData
import com.example.recipe.domain.usecases.GetRandomRecipe
import com.example.recipe.domain.usecases.SaveRecipe
import com.example.recipe.ui.viewDataModels.RecipeViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject internal constructor(
    private val getRandomRecipe: GetRandomRecipe,
    private val saveRecipe: SaveRecipe
) : ViewModel() {

    private val _viewData: MutableLiveData<HomeViewData> = MutableLiveData(HomeViewData.loading)
    val viewData: LiveData<HomeViewData> = _viewData

    init {
        viewModelScope.launch {
            val result = getRandomRecipe.invoke()

            //TODO - Make this user-driven
            result?.let {
                saveRecipe.save(it)
            }

            //TODO - Handle error
            result?.toViewData()?.let {
                _viewData.value = HomeViewData.success(it)
            }
        }
    }
}