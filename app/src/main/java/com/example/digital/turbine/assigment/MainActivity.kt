package com.example.digital.turbine.assigment

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.digital.turbine.assigment.base.activities.BaseActivity

class MainActivity : BaseActivity() {

    init {
        TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main).also {
            setupObservers()
        }
    }

    override fun setupObservers() {
        showAdsViewModel.getLisOfAds().observe(this, Observer { listOfAds ->
            Log.e(TAG, "setupObservers::$listOfAds")
        })
    }

}