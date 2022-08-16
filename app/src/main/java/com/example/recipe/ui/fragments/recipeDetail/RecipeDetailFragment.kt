package com.example.recipe.ui.fragments.recipeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.recipe.R
import com.example.recipe.databinding.FragmentRecipeDetailBinding
import com.example.recipe.ui.adapters.ViewPagerAdapter
import com.example.recipe.ui.fragments.recipeDetail.detailsTabFragment.DetailsTabFragment
import com.example.recipe.ui.fragments.recipeDetail.ingredientsTabFragment.IngredientsTabFragment
import com.example.recipe.ui.fragments.recipeDetail.instructionsTabFragment.InstructionsTabFragment
import com.example.recipe.ui.viewDataModels.RecipeDetailViewData
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeDetailFragment : Fragment() {

    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RecipeDetailViewModel
    private lateinit var tabArray: List<String>
    private val args: RecipeDetailFragmentArgs by navArgs()

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

        getRecipeInformation()
        configureTabs()
        observeRecipe()
    }

    private fun getRecipeInformation() {
        viewModel.getRecipeInformation(args.recipeId)
    }

    private fun configureTabs() {
        tabArray = listOf(getString(R.string.title_details), getString(R.string.title_ingredients), getString(R.string.title_instructions))

        binding.ViewPager2.adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
    }

    private fun observeRecipe() {
        viewModel.viewData.observe(viewLifecycleOwner) { viewData ->
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

        val pagerAdapter = (binding.ViewPager2.adapter as ViewPagerAdapter)
        pagerAdapter.addFragment(DetailsTabFragment(viewData.recipe))
        pagerAdapter.addFragment(IngredientsTabFragment(viewData.recipe?.ingredients))
        pagerAdapter.addFragment(InstructionsTabFragment(viewData.recipe))
        binding.ViewPager2.adapter = pagerAdapter

        TabLayoutMediator(binding.TabLayout, binding.ViewPager2) { tab, position ->
            tab.text = tabArray[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}