package com.example.recipe.ui.fragments.recipeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.recipe.R
import com.example.recipe.databinding.FragmentRecipeDetailBinding
import com.example.recipe.ui.adapters.ViewPagerAdapter
import com.example.recipe.ui.fragments.recipeDetail.detailsTabFragment.DetailsTabFragment
import com.example.recipe.ui.fragments.recipeDetail.ingredientsTabFragment.IngredientsTabFragment
import com.example.recipe.ui.fragments.recipeDetail.instructionsTabFragment.InstructionsTabFragment
import com.google.android.material.tabs.TabLayoutMediator

class RecipeDetailFragment : Fragment() {

    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get() = _binding!! // what does this do?
    private lateinit var viewModel: RecipeDetailViewModel

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

        val tabArray = listOf(
            getString(R.string.title_details),
            getString(R.string.title_ingredients),
            getString(R.string.title_instructions)
        )

        val viewPager = binding.ViewPager2
        val tabLayout = binding.TabLayout
        val pagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)

        viewModel.viewData.observe(viewLifecycleOwner) { viewData ->
            Glide.with(binding.root)
                .load(viewData.recipe.image)
                .error(R.drawable.ic_baseline_image)
                .fitCenter()
                .placeholder(R.drawable.ic_baseline_fastfood)
                .into(binding.Image)

            binding.Name.text = viewData.recipe.name

            pagerAdapter.addFragment(DetailsTabFragment(viewData.recipe))
            pagerAdapter.addFragment(IngredientsTabFragment(viewData.recipe.ingredients))
            pagerAdapter.addFragment(InstructionsTabFragment(viewData.recipe))
            viewPager.adapter = pagerAdapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = tabArray[position]
            }.attach()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}