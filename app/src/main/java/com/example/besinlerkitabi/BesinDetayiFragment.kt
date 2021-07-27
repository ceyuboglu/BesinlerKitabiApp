package com.example.besinlerkitabi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class BesinDetayiFragment : Fragment() {

    private var besinId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_detayi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let{
            besinId = BesinDetayiFragmentArgs.fromBundle(it).besinId
            println(besinId)
        }
        view.findViewById<Button>(R.id.besin_detayi_button).setOnClickListener(){
            Navigation.findNavController(it).navigate(R.id.action_besinDetayiFragment_to_besinListesiFragment)
        }
    }
}