package com.jetpack.sunflower

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.jetpack.sunflower.databinding.ActivityGardenBinding

class GardenActivity : AppCompatActivity(),HomeViewPagerFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Debug.startMethodTracing("GardenActivityOnCreate")

        window.setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        val binding = setContentView<ActivityGardenBinding>(this, R.layout.activity_garden)
//        Debug.stopMethodTracing()
    }

    override fun onFragmentInteraction(uri: Uri) {
        Toast.makeText(this@GardenActivity, "GardenActivity onFragmentInteraction:$uri",Toast.LENGTH_SHORT).show()
    }

    fun btShowScrollingActivity(view: View) {
        val intent = Intent(this@GardenActivity,ScrollingActivity::class.java)
        startActivity(intent)
    }
}
