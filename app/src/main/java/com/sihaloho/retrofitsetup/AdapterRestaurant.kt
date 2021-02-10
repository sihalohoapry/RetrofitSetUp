package com.sihaloho.retrofitsetup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sihaloho.retrofitsetup.databinding.ListRestaurantBinding

class AdapterRestaurant : RecyclerView.Adapter<AdapterRestaurant.RestaurantViewModel>() {

    private var list = ArrayList<Restaurant>()
    var onClick : ((Restaurant)->Unit)? = null

    fun setData(newList: List<Restaurant>?){
        if (newList == null) return
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }


    inner class RestaurantViewModel(view: View): RecyclerView.ViewHolder(view){

        val binding = ListRestaurantBinding.bind(view)
        fun bind(data : Restaurant){
            with(binding){
                tvNama.text = data.name
                tvDeskripsi.text = data.description
            }
        }

        init {
            binding.root.setOnClickListener {
                onClick?.invoke(list[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewModel =
        RestaurantViewModel(LayoutInflater.from(parent.context).inflate(R.layout.list_restaurant, parent,false))

    override fun onBindViewHolder(holder: RestaurantViewModel, position: Int) {
        val data = list[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = list.size

}