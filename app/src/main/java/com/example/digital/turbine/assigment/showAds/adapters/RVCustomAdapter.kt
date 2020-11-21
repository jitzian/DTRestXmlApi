package com.example.digital.turbine.assigment.showAds.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digital.turbine.assigment.databinding.AdItemBinding
import com.example.digital.turbine.assigment.rest.model.Ad
import com.example.digital.turbine.assigment.showAds.ui.fragments.ItemDetailsDialogFragment
import com.example.digital.turbine.assigment.showAds.ui.model.AdDetailUI
import com.squareup.picasso.Picasso

class RVCustomAdapter(private val supportFragmentManager: FragmentManager) :
    RecyclerView.Adapter<RVCustomAdapter.ViewHolder>() {

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
        private lateinit var dataUI: AdDetailUI

        fun bindData(data: Ad) {
            Picasso.get()
                .load(data.productThumbnail)
                .into(binding.mImageViewAdItem)

            binding.mTextViewCategoryNameAdItem.text = data.categoryName
            binding.mTexViewProductDescriptionAdItem.text = data.productDescription

            loadViewModel(data)
            setupListeners()
        }

        private fun loadViewModel(data: Ad) {
            dataUI = AdDetailUI(
                data.appId,
                data.averageRatingImageURL
            )
        }

        private fun setupListeners() {
            binding.mButtonShowDetailAdItem.setOnClickListener {
                ItemDetailsDialogFragment.newInstance(dataUI)
                    .show(supportFragmentManager, ItemDetailsDialogFragment::class.java.simpleName)
            }
        }
    }

    fun setListOfAds(listOfAds: List<Ad>) {
        lstRes = listOfAds
        notifyDataSetChanged()
    }

}
