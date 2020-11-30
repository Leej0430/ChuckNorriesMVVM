package com.example.chucknorriesmvvm.ViewModel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucknorriesmvvm.Model.NorrisRepository

/**
 * Controls the communication between
 * Views and Models.
 *
 */
class NorriesViewModel(val repository: NorrisRepository): ViewModel() {
    //Create a private Mutable to change
    //Locally the "new" Data from Model
   private val jokeMutableLivedata =
           MutableLiveData<String>()

    /**
     * Expose Protected (setValue,postValue)
     * so the View cannot change the Data
     */

    fun getJokeLiveData(): LiveData<String>{
        return jokeMutableLivedata
    }


}