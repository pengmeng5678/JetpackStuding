package com.jetpack.sunflower.data

import com.google.samples.apps.sunflower.data.GardenPlanting

class GardenPlantingRepository private constructor(
        private  val gardenPlantingDao: GardenPlantingDao
){
    companion object{
        @Volatile private var instance:GardenPlantingRepository? = null
        fun getInstance(dao:GardenPlantingDao) =
                instance?: synchronized(this){
                    instance?: GardenPlantingRepository(dao).also { instance = it }
                }
    }
    suspend fun createGardenPlanting(plantId:String){
        val gardenPlanting = GardenPlanting(plantId)
        gardenPlantingDao.insertGardenPlanting(gardenPlanting)
    }
    suspend fun removeGardenPlanting(gardenPlanting: GardenPlanting) {
        gardenPlantingDao.deleteGardenPlanting(gardenPlanting)
    }

    fun isPlanted(plantId: String) =
            gardenPlantingDao.isPlanted(plantId)

    fun getPlantedGardens() = gardenPlantingDao.getPlantedGardens()


}
