package com.studing.myjetpackstudingkt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.studing.myjetpackstudingkt.ui.ScrollingActivity
import com.studing.myjetpackstudingkt.ui.SettingsActivity
import com.studing.myjetpackstudingkt.ui.buttonnavigation.ButtomNavigationActivity
import com.studing.myjetpackstudingkt.ui.masterdetail.ItemListActivity
import com.studing.myjetpackstudingkt.ui.navigationdrawer.NavigationDrawerActivity
import com.studing.myjetpackstudingkt.ui.tabed.TabbedActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goScrollingActivity(view: View) {
        goActivity(ScrollingActivity::class.java)
    }

    private fun goActivity(clazz: Class<*>) {
        startActivity(Intent(this@MainActivity,clazz))
    }

    fun goButtomNavigationActivity(view: View) {
        goActivity(ButtomNavigationActivity::class.java)
    }
    fun goNavigationDrawer(view: View) {
        goActivity(NavigationDrawerActivity::class.java)
    }
    fun goSettingActivity(view: View) {
        goActivity(SettingsActivity::class.java)
    }

    fun goTabbedActivity(view: View) {
        goActivity(TabbedActivity::class.java)
    }

    fun goMasterDetailActivity(view: View) {
        goActivity(ItemListActivity::class.java)
    }
}
