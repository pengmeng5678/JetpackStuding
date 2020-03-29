package com.jetpack.sunflower

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ShareCompat
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.jetpack.sunflower.data.Plant
import com.jetpack.sunflower.databinding.FragmentPlantDetailBinding
import com.jetpack.sunflower.utilties.InjectorUtils
import com.jetpack.sunflower.viewmodels.PlantDetailViewModel

class PlantDetailFragment : Fragment() {
    /*nav_garden.xml文件中定义了name为plantId的argument*/
    private val args : PlantDetailFragmentArgs by navArgs()

    private val plantDetailViewModel: PlantDetailViewModel by viewModels {
        InjectorUtils.providePlantDetailViewModel(requireContext(),args.plantId)
    }
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPlantDetailBinding>(
                inflater,R.layout.fragment_plant_detail,container,false
        ).apply{
            viewModel = plantDetailViewModel
            lifecycleOwner = viewLifecycleOwner
            callback = object:Callback{
                override fun add(plant: Plant?) {
                    plant?.let {
                        hideAppBarFab(fab)
                        plantDetailViewModel.addPlantToGarden()
                        Snackbar.make(root,"Add plant to garden",Snackbar.LENGTH_LONG).show()
                    }
                }
            }
            var isToolbarShown = false
            plantDetailScrollview.setOnScrollChangeListener(
                    NestedScrollView.OnScrollChangeListener{_,_,scrollY,_,_ ->
                        // User scrolled past image to height of toolbar and the title text is
                        // underneath the toolbar, so the toolbar should be shown.
                        val shouldShowToolbar = scrollY > toolbar.height
                        // The new state of the toolbar differs from the previous state; update
                        // appbar and toolbar attributes.
                        if (isToolbarShown != shouldShowToolbar) {
                            isToolbarShown = shouldShowToolbar

                            // Use shadow animator to add elevation if toolbar is shown
                            appbar.isActivated = shouldShowToolbar

                            // Show the plant name if toolbar is shown
                            toolbarLayout.isTitleEnabled = shouldShowToolbar
                        }
                    }
            )
            toolbar.setNavigationOnClickListener{view ->
                view.findNavController().navigateUp()
            }
            toolbar.setOnMenuItemClickListener { item->
                when(item.itemId){
                    R.id.action_share ->{
                        createShareIntent()
                        true
                    }
                    else -> false
                }
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    // Helper function for calling a share functionality.
    // Should be used when user presses a share button/menu item.
    @Suppress("DEPRECATION")
    private fun createShareIntent() {
        val shareText = plantDetailViewModel.plant.value.let { plant ->
            if (plant == null) {
                ""
            } else {
                getString(R.string.share_text_plant, plant.name)
            }
        }
        val shareIntent = ShareCompat.IntentBuilder.from(activity)
                .setText(shareText)
                .setType("text/plain")
                .createChooserIntent()
                .apply {
                    // https://android-developers.googleblog.com/2012/02/share-with-intents.html
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        // If we're on Lollipop, we can open the intent as a document
                        addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
                    } else {
                        // Else, we will use the old CLEAR_WHEN_TASK_RESET flag
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
                    }
                }
        startActivity(shareIntent)
    }

    private fun hideAppBarFab(fab: FloatingActionButton) {
        val params = fab.layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as FloatingActionButton.Behavior
        behavior.isAutoHideEnabled = false
        fab.hide()
    }

    interface Callback {
        fun add(plant: Plant?)
    }
}
