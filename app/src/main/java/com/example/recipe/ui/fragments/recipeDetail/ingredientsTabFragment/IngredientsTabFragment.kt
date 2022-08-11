package com.example.recipe.ui.fragments.recipeDetail.ingredientsTabFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe.databinding.FragmentIngredientsTabBinding
import com.example.recipe.ui.adapters.IngredientAdapter
import com.example.recipe.ui.viewDataModels.IngredientsViewData

class IngredientsTabFragment(
    val ingredients: List<IngredientsViewData>
) : Fragment() {

    private var _binding: FragmentIngredientsTabBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: IngredientsTabViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIngredientsTabBinding.inflate(inflater, container, false)

        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureIngredientList()
    }

    private fun configureIngredientList() = with(binding.IngredientsRV) {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        adapter = IngredientAdapter(ingredients)
    }
}