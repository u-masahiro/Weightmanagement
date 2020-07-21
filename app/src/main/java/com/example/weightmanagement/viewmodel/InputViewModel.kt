package com.example.weightmanagement.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weightmanagement.model.Data
import com.example.weightmanagement.model.MainRepository


class InputViewModel() : ViewModel(){
    private val _weights = MutableLiveData<MutableList<Data>>()
    val weights: LiveData<MutableList<Data>> = _weights


    fun setWeights(element:Data) {
        _weights.value?.add(element)
    }

    init {
        _weights.value = mutableListOf<Data>()
        val repository = MainRepository()
        repository.getWeight().forEach {
            _weights.value?.add(it)
        }
    }
}