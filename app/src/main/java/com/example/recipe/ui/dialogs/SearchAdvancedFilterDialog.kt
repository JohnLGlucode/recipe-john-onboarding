package com.example.recipe.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.recipe.databinding.DialogAdvancedSearchOptionsBinding

class SearchAdvancedFilterDialog: DialogFragment() {

    private lateinit var binding: DialogAdvancedSearchOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DialogAdvancedSearchOptionsBinding.inflate(inflater, container, false)

        return binding.root
    }
}