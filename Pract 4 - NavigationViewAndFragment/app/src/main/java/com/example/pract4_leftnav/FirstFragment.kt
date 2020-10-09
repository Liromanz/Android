package com.example.pract4_leftnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.pract4_leftnav.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding : FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_first, container, false)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false)
        binding.impostorBtn.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_firstFragment2_to_impostorFragment)
        }
        return binding.root
    }
}