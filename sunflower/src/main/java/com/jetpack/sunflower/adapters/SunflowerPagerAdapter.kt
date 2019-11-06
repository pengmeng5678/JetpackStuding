package com.jetpack.sunflower.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jetpack.sunflower.GardenFragment
import com.jetpack.sunflower.MY_GARDEN_PAGE_INDEX
import com.jetpack.sunflower.PLANT_LIST_PAGE_INDEX
import com.jetpack.sunflower.PlantListFragment

class SunflowerPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private  val tabFragmentCreators : Map<Int,() -> Fragment> = mapOf(
            MY_GARDEN_PAGE_INDEX to { GardenFragment() },
            PLANT_LIST_PAGE_INDEX to { PlantListFragment() }
    )
    override fun getItemCount(): Int {
        return tabFragmentCreators.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabFragmentCreators[position]?.invoke()?:throw IndexOutOfBoundsException()
    }

}
