package com.example.recipe.ui.fragments.saved

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.recipe.domain.usecases.SavedRecipesProvider
import com.example.recipe.ui.viewDataModels.SavedViewData
import com.example.recipe.ui.viewDataModels.toViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject internal constructor(
    savedRecipesProvider: SavedRecipesProvider
) : ViewModel() {

    val viewData: LiveData<SavedViewData> = savedRecipesProvider.savedRecipes.map { recipes ->
        SavedViewData(recipes.map { it.toViewData() })
    }.asLiveData()
}