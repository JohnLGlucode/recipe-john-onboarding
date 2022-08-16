package com.example.recipe.ui.fragments.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe.databinding.FragmentSavedBinding
import com.example.recipe.ui.adapters.RecipeAdapter
import com.example.recipe.ui.viewDataModels.RecipeViewData
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
            (binding.SavedRecipes.adapter as RecipeAdapter).updateData(viewData.searchRecipes)
        }
    }

    private fun configureSavedRecipeList() = with(binding.SavedRecipes) {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        adapter = RecipeAdapter(emptyList()) {
            goToRecipeDetail(it)
        }
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