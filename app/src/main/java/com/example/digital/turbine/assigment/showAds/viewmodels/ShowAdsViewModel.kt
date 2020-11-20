package com.example.digital.turbine.assigment.showAds.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.digital.turbine.assigment.base.viewmodels.BaseViewModel
import com.example.digital.turbine.assigment.dagger.components.DaggerComponentInjector
import com.example.digital.turbine.assigment.dagger.modules.RetrofitModule
import com.example.digital.turbine.assigment.rest.RestApi
import com.example.digital.turbine.assigment.rest.model.Ad
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import java.util.logging.Logger
import javax.inject.Inject

class ShowAdsViewModel : BaseViewModel() {
    private val injector = DaggerComponentInjector.builder()
        .retrofitModule(RetrofitModule())
        .build()

    @Inject
    lateinit var retrofit: Retrofit

    init {
        TAG = ShowAdsViewModel::class.java.simpleName
        logger = Logger.getLogger(TAG)
        inject()
    }

    private fun inject() {
        injector.inject(this)
        restApi = retrofit.create(RestApi::class.java)
        fetchRemoteData()
    }

    private val listOfAds: MutableLiveData<List<Ad>> by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        MutableLiveData<List<Ad>>()
    }

    fun getLisOfAds(): LiveData<List<Ad>> {
        return listOfAds
    }

    private fun fetchRemoteData() = viewModelScope.launch(Dispatchers.IO) {
        listOfAds.postValue(restApi.getAds().execute().body()?.listOfAds)
    }

}