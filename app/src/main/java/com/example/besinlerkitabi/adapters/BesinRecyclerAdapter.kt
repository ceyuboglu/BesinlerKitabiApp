package com.example.besinlerkitabi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.besinlerkitabi.R
import com.example.besinlerkitabi.model.Besin
import com.example.besinlerkitabi.view.BesinListesiFragmentDirections

class BesinRecyclerAdapter(val besinListesi : ArrayList<Besin>):RecyclerView.Adapter<BesinRecyclerAdapter.BesinViewHolder>() {
    class BesinViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var isim: TextView? = null
        var kalori: TextView? = null
        init {
            isim = itemView.findViewById(R.id.besinIsmi)
            kalori = itemView.findViewById(R.id.besinKalorisi)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.besin_recycler_row,parent,false)
        return BesinViewHolder(view)
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        holder.isim!!.text = besinListesi.get(position).besinIsim
        holder.kalori!!.text = besinListesi.get(position).besinKalori

        holder.itemView.setOnClickListener{
            val action = BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayiFragment(0)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return besinListesi.size
    }

    fun besinListesiGuncelle(yeniBesinListesi: List<Besin>){
        besinListesi.clear()
        besinListesi.addAll(yeniBesinListesi)
        notifyDataSetChanged()
    }
}