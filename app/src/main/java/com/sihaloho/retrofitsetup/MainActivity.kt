package com.sihaloho.retrofitsetup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sihaloho.retrofitsetup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getListRestaurants()
        val data = mainViewModel.listReview

        val adapterBarang = AdapterRestaurant()
        with(binding.rvList) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = adapterBarang
        }

        mainViewModel.listReview.observe(this,{
            adapterBarang.setData(it)
        })

    }
}