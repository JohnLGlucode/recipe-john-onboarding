package com.example.recipe.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.recipe.R
import com.example.recipe.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewData.observe(viewLifecycleOwner) { viewData ->
            binding.recipeItem.RecipeTitle.text = viewData.recipe.name
            binding.recipeItem.Time.text = viewData.recipe.prepTime

            Glide.with(this)
                .load(viewData.recipe.image)
                .error(R.drawable.ic_baseline_image)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_fastfood)
                .into(binding.recipeItem.RecipeImage)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}