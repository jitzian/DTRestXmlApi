package com.example.digital.turbine.assigment.showAds.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digital.turbine.assigment.base.activities.BaseActivity
import com.example.digital.turbine.assigment.databinding.ActivityMainBinding
import com.example.digital.turbine.assigment.showAds.adapters.RVCustomAdapter
import com.example.digital.turbine.networkuitl.ConnectionType

class ShowAdsMainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: RVCustomAdapter

    init {
        TAG = ShowAdsMainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState).also {
            initView()
        }
    }

    override fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        initNetworkListener()
    }

    private fun initNetworkListener(){
        networkMonitor.result = { isAvailable, type ->
            runOnUiThread {
                when (isAvailable) {
                    true -> {
                        when (type) {
                            ConnectionType.Wifi -> {
                                Log.i("NETWORK_MONITOR_STATUS", "Wifi Connection")
                                isConnected = true
                                setupObservers()
                            }
                            ConnectionType.Cellular -> {
                                Log.i("NETWORK_MONITOR_STATUS", "Cellular Connection")
                                isConnected = true
                                setupObservers()
                            }
                            else -> { }
                        }
                    }
                    false -> {
                        Log.i("NETWORK_MONITOR_STATUS", "No Connection")
                        isConnected = false
                    }
                }
            }
        }
    }

    override fun setupObservers() {
        if(isConnected) {
            showAdsViewModel.getLisOfAds().observe(this, Observer { listOfAds ->
                Log.e(TAG, "setupObservers::$listOfAds")
                adapter = RVCustomAdapter(supportFragmentManager)
                adapter.setListOfAds(listOfAds)
                binding.mRecyclerViewMainScreen.adapter = adapter

            })
        }
    }

    private fun setupRecyclerView() {
        layoutManager = LinearLayoutManager(this)
        binding.mRecyclerViewMainScreen.layoutManager = layoutManager
    }

}