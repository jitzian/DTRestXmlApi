package com.example.digital.turbine.assigment.base.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.digital.turbine.assigment.base.factories.ViewModelFactory
import com.example.digital.turbine.assigment.showAds.viewmodels.ShowAdsViewModel
import com.example.digital.turbine.networkuitl.NetworkMonitorUtil
import kotlin.properties.Delegates

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var TAG: String
    protected var networkMonitor: NetworkMonitorUtil by Delegates.notNull()
    protected var isConnected = false

    protected val showAdsViewModel: ShowAdsViewModel by viewModels {
        ViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState).also {
            networkMonitor = NetworkMonitorUtil(this)
        }
    }

    override fun onResume() {
        super.onResume().also {
            networkMonitor.register()
        }
    }

    override fun onStop() {
        super.onStop().also {
            networkMonitor.unregister()
        }
    }

    abstract fun setupObservers()
    abstract fun initView()

}