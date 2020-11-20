package com.example.digital.turbine.assigment.showAds.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.example.digital.turbine.assigment.base.fragments.BaseDialogFragment
import com.example.digital.turbine.assigment.databinding.ItemDetailsFragmentBinding
import com.example.digital.turbine.assigment.showAds.ui.model.AdDetailUI

class ItemDetailsDialogFragment : BaseDialogFragment() {
    private lateinit var binding: ItemDetailsFragmentBinding

    init {
        TAG = ItemDetailsDialogFragment::class.java.simpleName
    }

    companion object {

        private const val appId = "appId"
        private const val averageRatingImageURL = "averageRatingImageURL"

        fun newInstance(data: AdDetailUI): ItemDetailsDialogFragment {
            val args = Bundle()

            args.putString(appId, data.appId)
            args.putString(averageRatingImageURL, data.averageRatingImageURL)

            val fragment = ItemDetailsDialogFragment()
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = ItemDetailsFragmentBinding.inflate(inflater)
        initView()
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupContent()
    }

    private fun setupContent(){
        binding.mTextViewAppIdItemDetails.text = arguments?.getString(appId)
    }

    override fun initView() {
        rootView = binding.root
    }

    override fun onStart() {
        super.onStart().also {
            dialog?.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
        }
    }

}