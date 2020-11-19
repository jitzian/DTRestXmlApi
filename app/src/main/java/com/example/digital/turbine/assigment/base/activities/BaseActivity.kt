package com.example.digital.turbine.assigment.base.activities

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.digital.turbine.assigment.base.factories.ViewModelFactory
import com.example.digital.turbine.assigment.showAds.viewmodels.ShowAdsViewModel

abstract class BaseActivity : AppCompatActivity() {
    protected lateinit var TAG: String

    protected val showAdsViewModel: ShowAdsViewModel by viewModels {
        ViewModelFactory()
    }

    abstract fun setupObservers()
    abstract fun initView()
}