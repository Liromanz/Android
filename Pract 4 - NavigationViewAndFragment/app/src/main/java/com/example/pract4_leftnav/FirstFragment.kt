package com.example.pract4_leftnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.pract4_leftnav.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment() {

    lateinit var  communicator: Communicator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_first, container, false)
        communicator = activity as Communicator

        view.impostorBtn.setOnClickListener{
            communicator.passDataCom(view.impostorCheck.text.toString())
        }
        return view
    }
}