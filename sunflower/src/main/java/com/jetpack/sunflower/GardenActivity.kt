package com.jetpack.sunflower

import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.jetpack.sunflower.databinding.ActivityGardenBinding

class GardenActivity : AppCompatActivity(),HomeViewPagerFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContentView<ActivityGardenBinding>(this,R.layout.activity_garden)
    }

    override fun onFragmentInteraction(uri: Uri) {
        Toast.makeText(this@GardenActivity,"GardenActivity onFragmentInteraction:"+uri.toString(),Toast.LENGTH_SHORT).show()
    }
}
