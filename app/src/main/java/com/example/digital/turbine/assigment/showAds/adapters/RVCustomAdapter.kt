package com.example.digital.turbine.assigment.showAds.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.digital.turbine.assigment.databinding.AdItemBinding
import com.example.digital.turbine.assigment.rest.model.Ad
import com.squareup.picasso.Picasso

class RVCustomAdapter : RecyclerView.Adapter<RVCustomAdapter.ViewHolder>() {

    private var lstRes: List<Ad>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AdItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        lstRes?.get(position)?.let { holder.bindData(it) }
    }

    override fun getItemCount(): Int {
        return lstRes?.size ?: 0
    }

    inner class ViewHolder(private val binding: AdItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: Ad) {
            Log.e("TAG", "bindData::${data.appId}")
            Picasso.get()
                .load(data.productThumbnail)
                .into(binding.mImageViewAdItem)
        }
    }

    fun setListOfAds(listOfAds: List<Ad>) {
        lstRes = listOfAds
        notifyDataSetChanged()
    }

}

//class RVCustomAdapter : RecyclerView.Adapter<RVCustomAdapter.ViewHolder>() {
//    private var lstRes: List<Ad>? = null
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.ad_item, parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        lstRes?.get(position)?.let { holder.bindData(it) }
//    }
//
//    override fun getItemCount(): Int {
//        return lstRes?.size ?: 0
//    }
//
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        fun bindData(data: Ad) {
//            Log.e("-->", "bindData::${data.appId}")
//        }
//    }
//
//    fun setListOfAds(listOfAds: List<Ad>) {
//        this.lstRes = listOfAds
//        notifyDataSetChanged()
//    }
//}