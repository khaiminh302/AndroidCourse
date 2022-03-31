package com.example.week4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week4.model.Restaurant

class ListRestaurantViewModel: ViewModel() {
    var _listOfRestaurant: MutableLiveData<List<Restaurant>> = MutableLiveData()
    val listOfRestaurant: LiveData<List<Restaurant>>
        get() = _listOfRestaurant

    fun getData() {
        val dataSet = DataStoreRestaurant.getDataSet()
        _listOfRestaurant.postValue(dataSet)
    }


}