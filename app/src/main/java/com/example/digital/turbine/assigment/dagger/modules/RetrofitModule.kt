package com.example.digital.turbine.assigment.dagger.modules

import com.example.digital.turbine.assigment.constants.GlobalConstants
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

@Module
class RetrofitModule {

    @Provides
    @Reusable
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .baseUrl(GlobalConstants.baseURL)
            .build()

    }
}