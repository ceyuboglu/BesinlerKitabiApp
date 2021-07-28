package com.example.besinlerkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.besinlerkitabi.R
import com.example.besinlerkitabi.adapters.BesinRecyclerAdapter
import com.example.besinlerkitabi.viewmodel.BesinListesiViewModel

class BesinListesiFragment : Fragment() {
    private lateinit var viewModel: BesinListesiViewModel
    private val recyclerBesinAdapter = BesinRecyclerAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_besin_listesi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(BesinListesiViewModel::class.java)
        viewModel.refreshData()
        val besinListRecycler = view.findViewById<RecyclerView>(R.id.besinListRecycler)
        besinListRecycler.layoutManager = LinearLayoutManager(context)
        besinListRecycler.adapter = recyclerBesinAdapter
        println("asdasdasd")
        observeLiveData()
        println("asd")
    }

    fun observeLiveData(){
        viewModel.besinler.observe(viewLifecycleOwner, Observer {
            it?.let{
                requireView().findViewById<RecyclerView>(R.id.besinListRecycler).visibility = View.VISIBLE
                recyclerBesinAdapter.besinListesiGuncelle(it)
            }
        })
        viewModel.besinHataMesaji.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    requireView().findViewById<TextView>(R.id.besinHataMesaji).visibility = View.VISIBLE
                } else {
                    requireView().findViewById<TextView>(R.id.besinHataMesaji).visibility = View.GONE
                }
            }
        })
        viewModel.besinYukleniyor.observe(viewLifecycleOwner, Observer {
            it?.let{
                if (it){
                    requireView().findViewById<RecyclerView>(R.id.besinListRecycler).visibility = View.GONE
                    requireView().findViewById<TextView>(R.id.besinHataMesaji).visibility = View.GONE
                    requireView().findViewById<TextView>(R.id.besinListesiProgressBar).visibility = View.VISIBLE
                }else{
                    requireView().findViewById<ProgressBar>(R.id.besinListesiProgressBar).visibility = View.GONE
                }
            }
        })
    }


}