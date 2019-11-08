package com.jetpack.sunflower.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jetpack.sunflower.data.GardenPlantingRepository
/*
*   通过这个Factory给GardenPlantingListViewModel注入repository
*/
class GardenPlantingListViewModelFactory(
        private val repository: GardenPlantingRepository
) :ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GardenPlantingListViewModel(repository) as T
    }
}
