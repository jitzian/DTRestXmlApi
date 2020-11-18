package com.example.digital.turbine.assigment.base.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.digital.turbine.assigment.showAds.viewmodels.ShowAdsVM
import java.lang.IllegalStateException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShowAdsVM::class.java)) {
            return ShowAdsVM() as T
        }
        throw IllegalStateException("ViewModel does not exist")
    }
}