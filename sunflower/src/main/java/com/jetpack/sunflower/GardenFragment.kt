package com.jetpack.sunflower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.jetpack.sunflower.adapters.GardenPlantingAdapter
import com.jetpack.sunflower.data.PlantAndGardenPlantings
import com.jetpack.sunflower.databinding.FragmentGardenBinding
import com.jetpack.sunflower.utilties.InjectorUtils
import com.jetpack.sunflower.viewmodels.GardenPlantingListViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [GardenFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [GardenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GardenFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentGardenBinding
    /*
        1.通过provideGardenPlantingListViewModelFactory方法创建GardenPlantingListViewModel
    *   2.GardenPlantingListViewModel构造方法接收GardenPlantingRepository,并通过这个数据仓库获取所有已经种植的植物的liveData
    *   3.GardenFragment通过监听这个viewModel的liveData更新ui
    */
    private val viewModel: GardenPlantingListViewModel by viewModels {
        InjectorUtils.provideGardenPlantingListViewModelFactory(requireContext())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentGardenBinding.inflate(inflater, container, false)
        binding.addPlant.setOnClickListener {
            navigateToPlantListPage()
        }
        val adapter = GardenPlantingAdapter()
        binding.gardenList.adapter = adapter
        subscribe(adapter,binding)
        return binding.root
    }

    private fun subscribe(adapter: GardenPlantingAdapter, binding: FragmentGardenBinding) {
        viewModel.plantAndGardenPlantings.observe(viewLifecycleOwner,object : Observer<List<PlantAndGardenPlantings>>{
            override fun onChanged(result: List<PlantAndGardenPlantings>?) {
                binding.hasPlantings = !result.isNullOrEmpty()
                adapter.submitList(result)
            }
        })
    }

    private fun navigateToPlantListPage() {
        requireActivity().findViewById<ViewPager2>(R.id.view_pager).currentItem = PLANT_LIST_PAGE_INDEX
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GardenFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                GardenFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
