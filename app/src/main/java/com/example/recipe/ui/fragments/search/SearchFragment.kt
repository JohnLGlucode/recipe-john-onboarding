package com.example.recipe.ui.fragments.search

import android.os.Bundle
import android.view.*
import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe.R
import com.example.recipe.databinding.FragmentSearchBinding
import com.example.recipe.ui.adapters.RecipeAdapter
import com.example.recipe.ui.viewDataModels.RecipeViewData

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SearchViewModel
    private var searchQuery: String? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

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
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun createSearchView(menu: Menu) {
        val searchItem = menu.findItem(R.id.SearchMenu_Search)
        val searchView = searchItem?.actionView as SearchView

        searchView.imeOptions = EditorInfo.IME_ACTION_DONE
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchQuery = query
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
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
            if (viewData.searchRecipes.isEmpty()) {
                if (searchQuery.isNullOrEmpty()) {
                    binding.EmptyListMessage.text = getString(R.string.title_search_recipes)
                } else {
                    binding.EmptyListMessage.text = getString(R.string.title_search_recipes_no_results)
                }

                binding.EmptyListMessage.visibility = View.VISIBLE
                (binding.SearchRecipes.adapter as RecipeAdapter).updateData(listOf())
            } else {
                (binding.SearchRecipes.adapter as RecipeAdapter).updateData(viewData.searchRecipes)
                binding.EmptyListMessage.visibility = View.GONE
            }
        }
    }

    private fun goToRecipeDetail(recipe: RecipeViewData) {
        findNavController().navigate(R.id.action_navigation_search_to_navigation_recipe_detail)
    }

}