package com.example.pract4_leftnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.pract4_leftnav.databinding.FragmentImpostorBinding
import kotlinx.android.synthetic.main.fragment_impostor.view.*

class ImpostorFragment : Fragment() {

    var displayMessage : String? = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_impostor, container, false)
        displayMessage = arguments?.getString("impostor")

        if (displayMessage == "impostor")
            view.textView2.text = "Пользователь приложения was The Impostor"
        else view.textView2.text = "Пользователь приложения was not The Impostor"
        return view
    }

}