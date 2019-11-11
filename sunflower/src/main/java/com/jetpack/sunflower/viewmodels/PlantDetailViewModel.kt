package com.jetpack.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpack.sunflower.data.GardenPlantingRepository
import com.jetpack.sunflower.data.PlantRepository
import kotlinx.coroutines.launch

class PlantDetailViewModel(
        plantRepository: PlantRepository,
        private val gardenPlantingRepository: GardenPlantingRepository,
        private val plantId:String
):ViewModel() {
        val isPlanted = gardenPlantingRepository.isPlanted(plantId)
        val plant = plantRepository.getPlant(plantId)

    fun addPlantToGarden(){
        viewModelScope.launch {
            gardenPlantingRepository.createGardenPlanting(plantId)
        }
    }
}
