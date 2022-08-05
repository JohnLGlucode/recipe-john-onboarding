package com.example.recipe.ui.fragments.recipeDetail.ingredientsTabFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipe.R

class IngredientsTabFragment : Fragment() {

    private lateinit var viewModel: IngredientsTabViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_ingredients_tab, container, false)
    }

}