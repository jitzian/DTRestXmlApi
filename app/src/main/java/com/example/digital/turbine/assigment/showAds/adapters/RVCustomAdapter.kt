package com.example.digital.turbine.assigment.showAds.adapters

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

            Picasso.get()
                .load(data.productThumbnail)
                .into(binding.mImageViewAdItem)

            binding.mTextViewCategoryNameAdItem.text = data.categoryName
            binding.mTexViewProductDescriptionAdItem.text = data.productDescription
        }
    }

    fun setListOfAds(listOfAds: List<Ad>) {
        lstRes = listOfAds
        notifyDataSetChanged()
    }

}
