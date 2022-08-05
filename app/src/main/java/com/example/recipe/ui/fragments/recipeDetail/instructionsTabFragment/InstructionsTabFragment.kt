package com.example.recipe.ui.fragments.recipeDetail.instructionsTabFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipe.R

class InstructionsTabFragment : Fragment() {

    private lateinit var viewModel: InstructionsTabViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_instructions_tab, container, false)
    }

}