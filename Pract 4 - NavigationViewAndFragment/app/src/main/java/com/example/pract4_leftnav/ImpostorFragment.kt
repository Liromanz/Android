package com.example.pract4_leftnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.pract4_leftnav.databinding.FragmentImpostorBinding

class ImpostorFragment : Fragment() {

    lateinit var binding : FragmentImpostorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_impostor, container, false)
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_impostor, container, false)
        return binding.root
    }

}