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
import com.example.recipe.core.extensions.visibleOrGone
import com.example.recipe.databinding.FragmentHomeBinding
import com.example.recipe.ui.viewDataModels.RecipeViewData
import com.google.android.material.snackbar.Snackbar
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
            toggleProgressLoading(viewData.isLoading)

            viewData.recipe ?: return@observe
            displayRecipe(viewData.recipe)
        }
    }

    private fun toggleProgressLoading(isLoading: Boolean) {
        binding.recipeItem.root.visibleOrGone(!isLoading)
        binding.RandomRecipeMessage.visibleOrGone(!isLoading)
        binding.ProgressBar.visibleOrGone(isLoading)
    }

    private fun displayRecipe(recipe: RecipeViewData) {
        binding.recipeItem.RecipeTitle.text = recipe.name
        binding.recipeItem.Time.text = recipe.prepTime

        Glide.with(this)
            .load(recipe.image)
            .error(R.drawable.ic_baseline_image)
            .fitCenter()
            .placeholder(R.drawable.ic_baseline_fastfood)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(50)))
            .into(binding.recipeItem.RecipeImage)

        if (recipe.isSaved) {
            binding.recipeItem.SaveRecipe.setImageResource(R.drawable.ic_bookmark_24)
        } else {
            binding.recipeItem.SaveRecipe.setImageResource(R.drawable.ic_bookmark_border_24)
        }

        binding.recipeItem.RecipeItemParent.setOnClickListener {
            goToRecipeDetail(recipe)
        }

        binding.recipeItem.SaveRecipe.setOnClickListener {
            viewModel.saveOrDeleteRecipe(recipe)

            if (recipe.isSaved) {
                Snackbar.make(binding.root, getString(R.string.title_recipe_removed_from_saved_recipes), Snackbar.LENGTH_SHORT).setAnchorView(R.id.nav_view).show()
            } else {
                Snackbar.make(binding.root, getString(R.string.title_recipe_saved), Snackbar.LENGTH_SHORT).setAnchorView(R.id.nav_view).show()
            }
        }
    }

    private fun goToRecipeDetail(recipe: RecipeViewData) {
        val action = HomeFragmentDirections.actionNavigationHomeToNavigationRecipeDetail(recipe.id)
        findNavController().navigate(action)
    }

}