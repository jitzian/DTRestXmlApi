package com.example.digital.turbine.assigment.dagger.components

import com.example.digital.turbine.assigment.dagger.modules.RetrofitModule
import dagger.Component

@Component(
    modules = [
        RetrofitModule::class
    ]
)
interface ComponentInjector {

    //TODO: Where to inject??
    fun inject()

    @Component.Builder
    interface Builder {
        fun retrofitModule(retrofitModule: RetrofitModule): Builder
        fun build(): ComponentInjector
    }

}