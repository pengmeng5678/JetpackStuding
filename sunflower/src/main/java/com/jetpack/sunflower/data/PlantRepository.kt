package com.jetpack.sunflower.data


/**
 * @author mengpeng
 * time   2019/11/7 16:09
 * describe	     TODO
 */
class PlantRepository private constructor(private val plantDao: PlantDao){
    fun getPlants() = plantDao.getPlants()

    fun getPlant(plantId:String) = plantDao.getPlant(plantId)

    fun getPlantsWithGrowZoneNumber(growZoneNumber:Int) =
            plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)

    companion object {
        @Volatile private var instance:PlantRepository ?= null
        fun getInstance(plantDao: PlantDao) =
                instance ?: synchronized(this){
                    instance?: PlantRepository(plantDao).also { instance = it }
                }
    }
}