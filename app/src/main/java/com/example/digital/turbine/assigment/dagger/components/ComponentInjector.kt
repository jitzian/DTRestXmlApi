package com.example.digital.turbine.assigment.dagger.components

import com.example.digital.turbine.assigment.dagger.modules.RetrofitModule
import com.example.digital.turbine.assigment.showAds.viewmodels.ShowAdsViewModel
import dagger.Component

@Component(
    modules = [
        RetrofitModule::class
    ]
)
interface ComponentInjector {

    fun inject(showAdsViewModel: ShowAdsViewModel)

    @Component.Builder
    interface Builder {
        fun retrofitModule(retrofitModule: RetrofitModule): Builder
        fun build(): ComponentInjector
    }

}