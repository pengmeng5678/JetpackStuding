package com.jetpack.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jetpack.sunflower.data.GardenPlantingRepository
import com.jetpack.sunflower.data.PlantRepository

class PlantDetailViewModelFactory(
        private val plantingListRepository: PlantRepository,
        private val gardenPlantingRepository: GardenPlantingRepository,
        private val plantId: String
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlantDetailViewModel(plantingListRepository,gardenPlantingRepository,plantId) as T
    }
}
