package com.example.recipe.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipe.R
import com.example.recipe.databinding.RecipeItemBinding
import com.example.recipe.ui.fragments.saved.RecipeViewData

class RecipeAdapter(
    private val recipes: List<RecipeViewData>,
    private var onRecipeClicked: ((recipe: RecipeViewData) -> Unit)
): RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    lateinit var binding: RecipeItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RecipeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size

    inner class ViewHolder(
        private val binding: RecipeItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: RecipeViewData) {
            binding.RecipeTitle.text = recipe.name
            binding.Time.text = recipe.prepTime

            Glide.with(binding.root)
                .load(recipe.image)
                .error(R.drawable.ic_baseline_image)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_fastfood)
                .into(binding.RecipeImage)

            if (recipe.isSaved) {
                binding.SaveRecipe.setImageResource(R.drawable.ic_bookmark_24)
            } else {
                binding.SaveRecipe.setImageResource(R.drawable.ic_bookmark_border_24)
            }

            binding.root.setOnClickListener { onRecipeClicked(recipe) }
        }

    }

}