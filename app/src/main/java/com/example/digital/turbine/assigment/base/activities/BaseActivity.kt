package com.example.digital.turbine.assigment.base.activities

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.digital.turbine.assigment.base.factories.ViewModelFactory
import com.example.digital.turbine.assigment.showAds.viewmodels.ShowAdsVM

abstract class BaseActivity : AppCompatActivity() {
    protected lateinit var TAG: String

    protected val showAdsVM: ShowAdsVM by viewModels {
        ViewModelFactory()
    }

}