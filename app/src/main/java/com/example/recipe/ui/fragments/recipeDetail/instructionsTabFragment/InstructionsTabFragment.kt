package com.example.recipe.ui.fragments.recipeDetail.instructionsTabFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipe.databinding.FragmentInstructionsTabBinding

class InstructionsTabFragment : Fragment() {

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
    }
}