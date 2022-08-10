package com.example.recipe.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipe.R
import com.example.recipe.databinding.ItemIngredientBinding
import com.example.recipe.ui.viewDataModels.IngredientsViewData

class IngredientAdapter(
    private val ingredients: List<IngredientsViewData>
): RecyclerView.Adapter<IngredientAdapter.ViewHolder>() {

    lateinit var binding: ItemIngredientBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemIngredientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ingredients[position])
    }

    override fun getItemCount(): Int = ingredients.size

    inner class ViewHolder(
        private val binding: ItemIngredientBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(ingredient: IngredientsViewData) {
            binding.Name.text = ingredient.name
            binding.Aisle.text = ingredient.aisle
            binding.MetricValue.text = ingredient.measures.metric
            binding.ImperialValue.text = ingredient.measures.imperial

            Glide.with(binding.root)
                .load(ingredient.image)
                .error(R.drawable.ic_baseline_image)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_fastfood)
                .into(binding.Image)
        }

    }

}