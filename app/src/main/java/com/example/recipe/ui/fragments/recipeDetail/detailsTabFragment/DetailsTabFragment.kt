package com.example.recipe.ui.fragments.recipeDetail.detailsTabFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipe.databinding.FragmentDetailsTabBinding

class DetailsTabFragment : Fragment() {

    private var _binding: FragmentDetailsTabBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsTabBinding.inflate(inflater, container, false)

        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.Summary.text = recipeViewData.recipe.summary
    }
}