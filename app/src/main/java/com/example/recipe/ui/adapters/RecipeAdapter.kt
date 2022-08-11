package com.example.recipe.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.recipe.R
import com.example.recipe.databinding.ItemRecipeBinding
import com.example.recipe.ui.viewDataModels.RecipeViewData

class RecipeAdapter(
    private var recipes: List<RecipeViewData> = listOf(),
    private var onRecipeClicked: ((recipe: RecipeViewData) -> Unit)
): RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    lateinit var binding: ItemRecipeBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size

    fun updateData(updatedRecipes: List<RecipeViewData>) {
        recipes = updatedRecipes
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: ItemRecipeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: RecipeViewData) {
            binding.RecipeTitle.text = recipe.name
            binding.Time.text = recipe.prepTime

            Glide.with(binding.root)
                .load(recipe.image)
                .error(R.drawable.ic_baseline_image)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_fastfood)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(50)))
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