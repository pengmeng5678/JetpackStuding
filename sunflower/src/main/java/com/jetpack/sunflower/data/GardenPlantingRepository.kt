package com.jetpack.sunflower.data

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

}
