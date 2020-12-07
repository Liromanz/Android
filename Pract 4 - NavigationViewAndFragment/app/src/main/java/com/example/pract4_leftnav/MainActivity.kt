package com.example.pract4_leftnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(navView, navController)
    }

    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("lat", "buka")
        bundle.putString("impostor", editTextInput)

        val fragmentImpostor = ImpostorFragment()
        fragmentImpostor.arguments = bundle
        Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.action_firstFragment_to_impostorFragment, bundle)
    }
}