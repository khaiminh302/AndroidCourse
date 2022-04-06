package com.example.week5.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week5.data.DataStoreRestaurant
import com.example.week5.model.Restaurant

class HomeRestaurantViewModel: ViewModel() {
    var _listOfRestaurant: MutableLiveData<List<Restaurant>> = MutableLiveData()
    val listOfRestaurant: LiveData<List<Restaurant>>
        get() = _listOfRestaurant

    fun getData() {
        val dataSet = DataStoreRestaurant.getDataSet()
        _listOfRestaurant.postValue(dataSet)
    }


}