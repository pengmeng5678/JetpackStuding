/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jetpack.sunflower.utilties

import android.content.Context
import com.jetpack.sunflower.data.AppDatabase
import com.jetpack.sunflower.data.GardenPlantingRepository
import com.jetpack.sunflower.data.PlantRepository
import com.jetpack.sunflower.viewmodels.GardenPlantingListViewModelFactory
import com.jetpack.sunflower.viewmodels.PlantListViewModelFactory


/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {
    private fun getPlantingListRepository(context: Context): PlantRepository {
        val dao = AppDatabase.getInstance(context.applicationContext).plantDao()
        return PlantRepository.getInstance(dao)
    }
    private fun getGardenPlantingRepository(context: Context): GardenPlantingRepository {
        val dao = AppDatabase.getInstance(context.applicationContext).gardenPlantingDao()
        return GardenPlantingRepository.getInstance(dao)
    }

    fun provideGardenPlantingListViewModelFactory(context: Context): GardenPlantingListViewModelFactory {
        val repository = getGardenPlantingRepository(context)
        return GardenPlantingListViewModelFactory(repository)
    }

    fun providePlantListViewModelModelFactory(context: Context): PlantListViewModelFactory {
        val repository = getPlantingListRepository(context)
        return PlantListViewModelFactory(repository)
    }

    private fun getPlantAndGardenPlantingRepository(context: Context): PlantRepository {
        val dao = AppDatabase.getInstance(context.applicationContext).plantDao()
        return PlantRepository.getInstance(dao)
    }




}
