package com.jetpack.sunflower.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jetpack.sunflower.data.PlantAndGardenPlantings
import com.jetpack.sunflower.databinding.ListItemGardenPlantingBinding

class GardenPlantingAdapter : ListAdapter<PlantAndGardenPlantings,GardenPlantingAdapter.ViewHolder>(GardenPlantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GardenPlantingAdapter.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: GardenPlantingAdapter.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(
            private val binding: ListItemGardenPlantingBinding
    ) : RecyclerView.ViewHolder(binding.root) {

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