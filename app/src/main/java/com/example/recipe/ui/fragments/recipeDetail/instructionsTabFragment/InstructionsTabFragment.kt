package com.example.recipe.ui.fragments.recipeDetail.instructionsTabFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe.databinding.FragmentInstructionsTabBinding
import com.example.recipe.ui.adapters.InstructionAdapter
import com.example.recipe.ui.viewDataModels.RecipeDetailModel

class InstructionsTabFragment(
    val recipeDetail: RecipeDetailModel?
) : Fragment() {

    private var _binding: FragmentInstructionsTabBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: InstructionsTabViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInstructionsTabBinding.inflate(inflater, container, false)

        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.InstructionsText.text = recipeDetail?.instructions
        configureInstructionsList()
    }

    private fun configureInstructionsList() = with(binding.InstructionsRV) {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        adapter = InstructionAdapter(recipeDetail!!.instructionSteps)
    }
}