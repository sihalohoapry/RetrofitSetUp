package com.sihaloho.retrofitsetup

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {


    private val _listReview = MutableLiveData<List<Restaurant>>()
    val listReview: LiveData<List<Restaurant>> = _listReview

    fun getListRestaurants(){

        val client = ApiConfig.getApiService().getListRestaurant()
        client.enqueue(object  : Callback<RestaurantResponse>{
            override fun onResponse(
                call: Call<RestaurantResponse>,
                response: Response<RestaurantResponse>
            ) {
                _listReview.value = response.body()?.restaurants
                Log.e(TAG, "Response Code: ${response.code()}}")

            }

            override fun onFailure(call: Call<RestaurantResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })

    }


}