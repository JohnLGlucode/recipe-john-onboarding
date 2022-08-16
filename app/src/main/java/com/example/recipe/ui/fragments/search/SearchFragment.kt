package com.example.recipe.ui.fragments.search

import android.os.Bundle
import android.view.*
import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe.R
import com.example.recipe.databinding.FragmentSearchBinding
import com.example.recipe.ui.adapters.RecipeAdapter
import com.example.recipe.ui.dialogs.SearchAdvancedFilterDialog
import com.example.recipe.ui.viewDataModels.RecipeViewData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private var searchQuery: String? = null

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureMenu()
        configureList()
        observeSearchResults()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun configureMenu() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.search_menu, menu)
                createSearchView(menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.SearchMenu_Search -> {
                        return true
                    }
                    R.id.SearchMenu_AdvancedFilter -> {
                        showAdvancedSearchDialog()
                        return true
                    }
                }
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun showAdvancedSearchDialog() {
        SearchAdvancedFilterDialog().show(childFragmentManager, "SearchAdvancedFilterDialog")
    }

    private fun createSearchView(menu: Menu) {
        val searchItem = menu.findItem(R.id.SearchMenu_Search)
        val searchView = searchItem?.actionView as SearchView

        searchView.imeOptions = EditorInfo.IME_ACTION_DONE
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchQuery = query
                searchRecipes()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun searchRecipes() {
        searchQuery?.let { viewModel.searchRecipes(query = it) }
    }

    private fun configureList() = with(binding.SearchRecipes) {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        adapter = RecipeAdapter {
            goToRecipeDetail(it)
        }
    }

    private fun observeSearchResults() {
        viewModel.viewData.observe(viewLifecycleOwner) { viewData ->
            viewData.searchRecipes ?: return@observe

            displaySearchResults(viewData.searchRecipes)
        }
    }

    private fun displaySearchResults(searchRecipes: List<RecipeViewData>) {
        if (searchRecipes.isEmpty()) {
            if (searchQuery.isNullOrEmpty()) {
                binding.EmptyListMessage.text = getString(R.string.title_search_recipes)
            } else {
                binding.EmptyListMessage.text = getString(R.string.title_search_recipes_no_results)
            }

            binding.EmptyListMessage.visibility = View.VISIBLE
            (binding.SearchRecipes.adapter as RecipeAdapter).updateData(listOf())
        } else {
            (binding.SearchRecipes.adapter as RecipeAdapter).updateData(searchRecipes)
            binding.EmptyListMessage.visibility = View.GONE
        }
    }

    private fun goToRecipeDetail(recipe: RecipeViewData) {
        val action = SearchFragmentDirections.actionNavigationSearchToNavigationRecipeDetail(recipe)
        findNavController().navigate(action)
    }

}