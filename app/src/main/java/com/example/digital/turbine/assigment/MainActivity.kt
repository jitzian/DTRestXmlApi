package com.example.digital.turbine.assigment

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digital.turbine.assigment.base.activities.BaseActivity
import com.example.digital.turbine.assigment.databinding.ActivityMainBinding
import com.example.digital.turbine.assigment.showAds.adapters.RVCustomAdapter

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: RVCustomAdapter

    init {
        TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState).also {
            initView()
        }
    }

    override fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObservers()
        setupRecyclerView()
    }

    override fun setupObservers() {
        showAdsViewModel.getLisOfAds().observe(this, Observer { listOfAds ->
            Log.e(TAG, "setupObservers::$listOfAds")
            adapter = RVCustomAdapter()
            adapter.setListOfAds(listOfAds)
            binding.mRecyclerViewMainScreen.adapter = adapter

        })
    }

    private fun setupRecyclerView() {
        layoutManager = LinearLayoutManager(this)
        binding.mRecyclerViewMainScreen.layoutManager = layoutManager
    }

}