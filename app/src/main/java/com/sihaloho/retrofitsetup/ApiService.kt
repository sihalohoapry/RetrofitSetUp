package com.sihaloho.retrofitsetup

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("list")
    fun getListRestaurant(): Call<RestaurantResponse>

}