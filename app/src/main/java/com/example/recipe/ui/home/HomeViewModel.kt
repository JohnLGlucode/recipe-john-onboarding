package com.example.recipe.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipe.models.Recipe

class HomeViewModel : ViewModel() {

    private val _randomRecipe = MutableLiveData<Recipe>().apply {

    }
    val randomRecipe: LiveData<Recipe> = _randomRecipe

}