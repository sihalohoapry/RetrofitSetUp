package com.sihaloho.retrofitsetup.retrofit

import com.sihaloho.retrofitsetup.data.RestaurantResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("list")
    fun getListRestaurant(): Call<RestaurantResponse>

}