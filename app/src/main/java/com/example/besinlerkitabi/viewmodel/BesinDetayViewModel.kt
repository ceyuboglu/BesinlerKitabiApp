package com.example.besinlerkitabi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.besinlerkitabi.model.Besin

class BesinDetayViewModel : ViewModel() {
    val besinLiveData = MutableLiveData<Besin>()

    fun roomVerisiniAl(){
        val muz = Besin("muz","100","20","450","2"," ")
        besinLiveData.value = muz
    }

}