package com.jetpack.sunflower.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jetpack.sunflower.HomeViewPagerFragmentDirections
import com.jetpack.sunflower.R
import com.jetpack.sunflower.data.PlantAndGardenPlantings
import com.jetpack.sunflower.databinding.ListItemGardenPlantingBinding
import com.jetpack.sunflower.viewmodels.PlantAndGardenPlantingsViewModel

class GardenPlantingAdapter : ListAdapter<PlantAndGardenPlantings,GardenPlantingAdapter.ViewHolder>(GardenPlantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GardenPlantingAdapter.ViewHolder {
        return ViewHolder(
                DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_item_garden_planting,parent,false)
        )
    }

    override fun onBindViewHolder(holder: GardenPlantingAdapter.ViewHolder, position: Int) {
        getItem(position)?.let { plantings ->
            with(holder){
                bind(plantings)
            }
        }
    }

    class ViewHolder(
            private val binding: ListItemGardenPlantingBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.viewModel?.plantId?.let {plantId ->
                    navigateToPlant(plantId,view)
                }
            }
        }

        private fun navigateToPlant(plantId: String, view: View) {
            val direction = HomeViewPagerFragmentDirections
                    .actionHomeViewPagerFragmentToPlantDetailFragment(plantId)
            view.findNavController().navigate(direction)
        }
        fun bind(plantings: PlantAndGardenPlantings){
            with(binding){
                viewModel = PlantAndGardenPlantingsViewModel(plantings)
                executePendingBindings()
            }
        }
    }

}
private class GardenPlantDiffCallback : DiffUtil.ItemCallback<PlantAndGardenPlantings>() {

    override fun areItemsTheSame(
            oldItem: PlantAndGardenPlantings,
            newItem: PlantAndGardenPlantings
    ): Boolean {
        return oldItem.plant.plantId == newItem.plant.plantId
    }

    override fun areContentsTheSame(
            oldItem: PlantAndGardenPlantings,
            newItem: PlantAndGardenPlantings
    ): Boolean {
        return oldItem.plant == newItem.plant
    }
}