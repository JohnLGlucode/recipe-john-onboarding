package com.example.recipe.ui.fragments.recipeDetail.detailsTabFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipe.databinding.FragmentDetailsTabBinding
import com.example.recipe.ui.fragments.recipeDetail.RecipeDetailModel

class DetailsTabFragment(
    val recipeDetail: RecipeDetailModel
) : Fragment() {

    private var _binding: FragmentDetailsTabBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsTabBinding.inflate(inflater, container, false)

        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.Summary.text = recipeDetail.summary
        binding.Servings.text = recipeDetail.servings.toString()
        binding.PrepTime.text = recipeDetail.prepTime
        binding.Cheap.text = recipeDetail.cheap
        binding.GlutenFree.text = recipeDetail.glutenFree
        binding.DairyFree.text = recipeDetail.dairyFree
        binding.Vegetarian.text = recipeDetail.vegetarian
        binding.Vegan.text = recipeDetail.vegan
    }
}