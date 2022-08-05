package com.example.recipe.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.recipe.ui.fragments.recipeDetail.detailsTabFragment.DetailsTabFragment
import com.example.recipe.ui.fragments.recipeDetail.ingredientsTabFragment.IngredientsTabFragment
import com.example.recipe.ui.fragments.recipeDetail.instructionsTabFragment.InstructionsTabFragment

private const val NUM_TABS = 3

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = NUM_TABS

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return DetailsTabFragment()
            1 -> return IngredientsTabFragment()
        }

        return InstructionsTabFragment()
    }

}