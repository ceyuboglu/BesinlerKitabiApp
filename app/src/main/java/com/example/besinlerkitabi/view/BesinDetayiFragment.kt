package com.example.besinlerkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.besinlerkitabi.R
import com.example.besinlerkitabi.viewmodel.BesinDetayViewModel
import org.w3c.dom.Text

class BesinDetayiFragment : Fragment() {

    private lateinit var viewModel : BesinDetayViewModel
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

        viewModel = ViewModelProvider(this).get(BesinDetayViewModel::class.java)
        viewModel.roomVerisiniAl()

        arguments?.let{
            besinId = BesinDetayiFragmentArgs.fromBundle(it).besinId
            println(besinId)
        }
        observeLiveData()
    }

    fun observeLiveData(){
        viewModel.besinLiveData.observe(viewLifecycleOwner, Observer {
            it?.let{
                requireView().findViewById<TextView>(R.id.besinDetayIsim).text = it.besinIsim
                requireView().findViewById<TextView>(R.id.besinDetayKalori).text = it.besinKalori
                requireView().findViewById<TextView>(R.id.besinDetayKarbonhidrat).text = it.besinKarbonhidrat
                requireView().findViewById<TextView>(R.id.besinDetayProtein).text = it.besinProtein
                requireView().findViewById<TextView>(R.id.besinDetayYag).text = it.besinYag
            }
        })
    }



}