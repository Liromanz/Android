package com.example.pract4_leftnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(navView, navController)

//        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//        navView.setNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.miItem1 -> Toast.makeText(applicationContext, "Тык 1", Toast.LENGTH_SHORT).show()
//                R.id.miItem2 -> Toast.makeText(applicationContext, "Тык 2", Toast.LENGTH_SHORT).show()
//                R.id.miItem3 -> Toast.makeText(applicationContext, "Тык 3", Toast.LENGTH_SHORT).show()
//            }
//            true
//        }
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (toggle.onOptionsItemSelected(item)){
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }
}