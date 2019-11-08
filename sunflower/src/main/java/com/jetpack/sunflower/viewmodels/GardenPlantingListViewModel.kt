package com.jetpack.sunflower.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jetpack.sunflower.data.GardenPlantingRepository
import com.jetpack.sunflower.data.PlantAndGardenPlantings

class GardenPlantingListViewModel internal constructor(repository: GardenPlantingRepository): ViewModel() {
    val plantAndGardenPlantings:LiveData<List<PlantAndGardenPlantings>> = repository.getPlantedGardens()
}
