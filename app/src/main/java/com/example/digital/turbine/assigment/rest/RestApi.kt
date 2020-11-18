package com.example.digital.turbine.assigment.rest

import com.example.digital.turbine.assigment.rest.model.Ads
import retrofit2.Call
import retrofit2.http.GET

interface RestApi {

    //TODO: Change
    @GET("getAds?id=236&password=OVUJ1DJN&siteId=10777&deviceId=4230&sessionId=techtestsession&totalCampaignsRequested=3")
    fun getAds(): Call<Ads>
}