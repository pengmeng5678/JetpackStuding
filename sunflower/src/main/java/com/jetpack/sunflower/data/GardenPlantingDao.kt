package com.jetpack.sunflower.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.google.samples.apps.sunflower.data.GardenPlanting

@Dao
interface GardenPlantingDao {
    @Query("SELECT * FROM garden_plantings")
    fun getGardenPlantings(): LiveData<List<GardenPlanting>>
}
