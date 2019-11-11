package com.jetpack.sunflower

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.jetpack.sunflower.adapters.PlantAdapter
import com.jetpack.sunflower.databinding.FragmentPlantListBinding
import com.jetpack.sunflower.utilties.InjectorUtils
import com.jetpack.sunflower.viewmodels.PlantListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [PlantListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [PlantListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlantListFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private val viewModel: PlantListViewModel by viewModels {
        InjectorUtils.providePlantListViewModelModelFactory(requireContext())
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
        val binding = FragmentPlantListBinding.inflate(inflater, container, false)
        val adapter = PlantAdapter()
        binding.plantList.adapter = adapter
        subscribeUi(adapter)
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(adapter: PlantAdapter) {
        viewModel.plants.observe(viewLifecycleOwner){plants ->
            adapter.submitList(plants)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_plant_list,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.filter_zone ->{
                updateData()
                true
            }else->super.onOptionsItemSelected(item)
        }
    }

    private fun updateData() {
        with(viewModel){
            if(isFilter()){
                clearGrowZoneNumber()
            }else{
                setGrowZoneNumber(9)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PlantListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                PlantListFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
