package com.example.besinlerkitabi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.besinlerkitabi.model.Besin

class BesinListesiViewModel : ViewModel() {
    val besinler = MutableLiveData<List<Besin>>()
    val besinHataMesaji = MutableLiveData<Boolean>()
    val besinYukleniyor = MutableLiveData<Boolean>()

    fun refreshData(){
        val muz = Besin("muz","100","20","450","2"," ")
        val cilek = Besin("cilek","120","60","455","36"," ")
        val elma = Besin("elma","200","20","410","55"," ")

        val besinListesi = arrayListOf<Besin>(muz,cilek,elma)

        besinler.value = besinListesi
        besinHataMesaji.value = false
        besinYukleniyor.value = false
    }
}