package com.example.recipe.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.recipe.R
import com.example.recipe.databinding.FragmentHomeBinding
import com.example.recipe.ui.viewDataModels.RecipeViewData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeRandomRecipe()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeRandomRecipe() {
        viewModel.viewData.observe(viewLifecycleOwner) { viewData ->
            //TODO - Handle loading state
            viewData.recipe ?: return@observe

            binding.recipeItem.RecipeTitle.text = viewData.recipe.name
            binding.recipeItem.Time.text = viewData.recipe.prepTime

            Glide.with(this)
                .load(viewData.recipe.image)
                .error(R.drawable.ic_baseline_image)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_fastfood)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(50)))
                .into(binding.recipeItem.RecipeImage)

            binding.recipeItem.RecipeItemParent.setOnClickListener {
                goToRecipeDetail(viewData.recipe)
            }
        }
    }

    private fun goToRecipeDetail(recipe: RecipeViewData) {
        findNavController().navigate(R.id.action_navigation_home_to_navigation_recipe_detail)
    }

}