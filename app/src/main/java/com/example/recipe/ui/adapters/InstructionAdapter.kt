package com.example.recipe.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.databinding.ItemInstructionBinding
import com.example.recipe.ui.fragments.recipeDetail.StepViewData

class InstructionAdapter(
    private val instructions: List<StepViewData>
): RecyclerView.Adapter<InstructionAdapter.ViewHolder>() {

    lateinit var binding: ItemInstructionBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemInstructionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(instructions[position])
    }

    override fun getItemCount(): Int = instructions.size

    inner class ViewHolder(
        private val binding: ItemInstructionBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(instruction: StepViewData) {
            binding.Step.text = instruction.number.toString()
            binding.StepName.text = instruction.step
            binding.StepLength.text = instruction.length
            binding.Ingredients.text = instruction.ingredients
        }

    }
}