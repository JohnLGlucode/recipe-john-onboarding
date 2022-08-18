package com.example.recipe.ui.dialogs.searchAdvancedFilter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.recipe.R
import com.example.recipe.databinding.DialogAdvancedSearchOptionsBinding
import com.example.recipe.ui.fragments.search.SearchViewModel
import com.example.recipe.ui.viewDataModels.SearchAdvancedFilterDialogViewData

class SearchAdvancedFilterDialog: DialogFragment() {

    private lateinit var binding: DialogAdvancedSearchOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DialogAdvancedSearchOptionsBinding.inflate(inflater, container, false)

        binding.CloseDialog.setOnClickListener {
            dismiss()
        }

        binding.SearchBtn.setOnClickListener {
            search()
        }

        return binding.root
    }

    private fun createAdvancedFilterObject(): SearchAdvancedFilterDialogViewData = SearchAdvancedFilterDialogViewData(
        cuisine = binding.Cuisine.selectedItem.toString().let {
            if (it == getString(R.string.title_please_select)) {
                null
            } else {
                it.lowercase()
            }
        },
        diet = binding.Diet.selectedItem.toString().let {
            if (it == getString(R.string.title_please_select)) {
                null
            } else {
                it.lowercase()
            }
        },
        intolerances = binding.Intolerances.selectedItem.toString().let {
            if (it == getString(R.string.title_please_select)) {
                null
            } else {
                it.lowercase()
            }
        },
        mealType = binding.MealType.selectedItem.toString().let {
            if (it == getString(R.string.title_please_select)) {
                null
            } else {
                it.lowercase()
            }
        },
        maxReadyTime = binding.MaxReadyTimeET.text.toString().toIntOrNull(),
        minCaffeine = binding.MinCaffeineET.text.toString().toIntOrNull(),
        maxCaffeine = binding.MaxCaffeineET.text.toString().toIntOrNull(),
        minCalcium = binding.MinCalciumET.text.toString().toIntOrNull(),
        maxCalcium = binding.MaxCalciumET.text.toString().toIntOrNull(),
        minCarbs = binding.MinCarbohydratesET.text.toString().toIntOrNull(),
        maxCarbs = binding.MaxCarbohydratesET.text.toString().toIntOrNull(),
        minCholesterol = binding.MinCholesterolET.text.toString().toIntOrNull(),
        maxCholesterol = binding.MaxCholesterolET.text.toString().toIntOrNull(),
        minFat = binding.MinFatET.text.toString().toIntOrNull(),
        maxFat = binding.MaxFatET.text.toString().toIntOrNull(),
        minFiber = binding.MinFiberET.text.toString().toIntOrNull(),
        maxFiber = binding.MaxFiberET.text.toString().toIntOrNull(),
        minIron = binding.MinIronET.text.toString().toIntOrNull(),
        maxIron = binding.MaxIronET.text.toString().toIntOrNull(),
        minProtein = binding.MinProteinET.text.toString().toIntOrNull(),
        maxProtein = binding.MaxProteinET.text.toString().toIntOrNull(),
        minSatFat = binding.MinSaturatedFatET.text.toString().toIntOrNull(),
        maxSatFat = binding.MaxSaturatedFatET.text.toString().toIntOrNull(),
        minSodium = binding.MinSodiumET.text.toString().toIntOrNull(),
        maxSodium = binding.MaxSodiumET.text.toString().toIntOrNull(),
        minSugar = binding.MinSugarET.text.toString().toIntOrNull(),
        maxSugar = binding.MaxSugarET.text.toString().toIntOrNull(),
        minZinc = binding.MinZincET.text.toString().toIntOrNull(),
        maxZinc = binding.MaxZincET.text.toString().toIntOrNull()
    )

    fun search() {
        createAdvancedFilterObject()

        dismiss()
    }

}