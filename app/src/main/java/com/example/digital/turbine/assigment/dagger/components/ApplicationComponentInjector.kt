package com.example.digital.turbine.assigment.dagger.components

import com.example.digital.turbine.assigment.application.CustomApp
import com.example.digital.turbine.assigment.dagger.modules.ApplicationModule
import dagger.Component

@Component(
    modules = [
        ApplicationModule::class
    ]
)
interface ApplicationComponentInjector {

    fun inject(customApp: CustomApp)

    @Component.Builder
    interface Builder {

        fun applicationModule(applicationModule: ApplicationModule): Builder
        fun build(): ApplicationComponentInjector
    }

}