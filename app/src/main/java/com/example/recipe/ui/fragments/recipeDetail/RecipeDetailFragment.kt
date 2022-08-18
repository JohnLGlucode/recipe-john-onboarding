package com.example.recipe.ui.fragments.recipeDetail

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.recipe.R
import com.example.recipe.core.extensions.visibleOrGone
import com.example.recipe.databinding.FragmentRecipeDetailBinding
import com.example.recipe.ui.adapters.ViewPagerAdapter
import com.example.recipe.ui.fragments.recipeDetail.detailsTabFragment.DetailsTabFragment
import com.example.recipe.ui.fragments.recipeDetail.ingredientsTabFragment.IngredientsTabFragment
import com.example.recipe.ui.fragments.recipeDetail.instructionsTabFragment.InstructionsTabFragment
import com.example.recipe.ui.viewDataModels.RecipeDetailViewData
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeDetailFragment : Fragment() {

    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RecipeDetailViewModel
    private val args: RecipeDetailFragmentArgs by navArgs()
    private lateinit var saveRecipeMenuItem: MenuItem
    private lateinit var deleteRecipeMenuItem: MenuItem
    private lateinit var menuHost: MenuHost
    private var isSaved: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(RecipeDetailViewModel::class.java)
        _binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureMenu()
        getRecipeInformation()
        observeRecipe()
    }

    private fun configureMenu() {
        menuHost = requireActivity()

        menuHost.addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.recipe_detail_menu, menu)

                saveRecipeMenuItem = menu.findItem(R.id.RecipeDetailMenu_Save)
                deleteRecipeMenuItem = menu.findItem(R.id.RecipeDetailMenu_Delete)
            }

            override fun onPrepareMenu(menu: Menu) {
                super.onPrepareMenu(menu)

                saveRecipeMenuItem.isVisible = !isSaved
                deleteRecipeMenuItem.isVisible = isSaved
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.RecipeDetailMenu_Save -> {
                        saveDeleteRecipe()
                        return true
                    }
                    R.id.RecipeDetailMenu_Delete -> {
                        saveDeleteRecipe()
                        return true
                    }
                }
                return false
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun saveDeleteRecipe() {
        viewModel.saveOrDelete(viewModel.viewData.value!!)

        if (viewModel.viewData.value!!.recipe?.isSaved == true) {
            Snackbar.make(binding.root, getString(R.string.title_recipe_removed_from_saved_recipes), Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(binding.root, getString(R.string.title_recipe_saved), Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun getRecipeInformation() {
        viewModel.getRecipeInformation(args.recipeId)
    }

    private fun toggleLoadingUI(isLoading: Boolean) {
        binding.ProgressBar.visibleOrGone(isLoading)
        binding.Name.visibleOrGone(!isLoading)
        binding.ViewPager2.visibleOrGone(!isLoading)
        binding.Image.visibleOrGone(!isLoading)
        binding.TabLayout.visibleOrGone(!isLoading)
    }

    private fun observeRecipe() {
        viewModel.viewData.observe(viewLifecycleOwner) { viewData ->
            toggleLoadingUI(viewData.isLoading)

            viewData.recipe ?: return@observe
            displayRecipeDetails(viewData)
        }
    }

    private fun displayRecipeDetails(viewData: RecipeDetailViewData) {
        Glide.with(binding.root)
            .load(viewData.recipe?.image)
            .error(R.drawable.ic_baseline_image)
            .fitCenter()
            .placeholder(R.drawable.ic_baseline_fastfood)
            .into(binding.Image)

        binding.Name.text = viewData.recipe?.name

        val pagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        pagerAdapter.addFragment(DetailsTabFragment(viewData.recipe))
        pagerAdapter.addFragment(IngredientsTabFragment(viewData.recipe?.ingredients))
        pagerAdapter.addFragment(InstructionsTabFragment(viewData.recipe))
        binding.ViewPager2.adapter = pagerAdapter

        val tabArray = listOf(getString(R.string.title_details), getString(R.string.title_ingredients), getString(R.string.title_instructions))

        TabLayoutMediator(binding.TabLayout, binding.ViewPager2) { tab, position ->
            tab.text = tabArray[position]
        }.attach()

        isSaved = if (viewData.recipe != null) {
            viewData.recipe.isSaved
        } else {
            false
        }

        menuHost.invalidateMenu()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}