package com.example.recipe.ui.fragments.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe.R
import com.example.recipe.core.extensions.visibleOrGone
import com.example.recipe.databinding.FragmentSavedBinding
import com.example.recipe.ui.adapters.RecipeAdapter
import com.example.recipe.ui.viewDataModels.RecipeViewData
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedFragment : Fragment() {

    private var _binding: FragmentSavedBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SavedViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(SavedViewModel::class.java)

        _binding = FragmentSavedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureSavedRecipeList()
        observeSavedRecipes()
    }

    private fun observeSavedRecipes() {
        viewModel.viewData.observe(viewLifecycleOwner) { viewData ->
            toggleSavedRecipesMessage(viewData.searchRecipes.isEmpty())

            (binding.SavedRecipes.adapter as RecipeAdapter).updateData(viewData.searchRecipes)
        }
    }

    private fun toggleSavedRecipesMessage(isEmpty: Boolean) {
        binding.SavedRecipes.visibleOrGone(!isEmpty)
        binding.EmptyListMessage.visibleOrGone(isEmpty)
    }

    private fun configureSavedRecipeList() = with(binding.SavedRecipes) {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        adapter = RecipeAdapter(
            recipes = emptyList(),
            onRecipeClicked = { goToRecipeDetail(it) },
            saveClicked = { deleteSavedRecipe(it) }
        )
    }

    private fun deleteSavedRecipe(viewData: RecipeViewData) {
        viewModel.deleteSavedRecipe(viewData)

        Snackbar.make(binding.root, getString(R.string.title_recipe_removed_from_saved_recipes), Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun goToRecipeDetail(recipe: RecipeViewData) {
        val action = SavedFragmentDirections.actionNavigationSavedToNavigationRecipeDetail(recipe.id)
        findNavController().navigate(action)
    }

}