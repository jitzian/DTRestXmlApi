package com.example.digital.turbine.assigment.dagger.modules

import com.example.digital.turbine.assigment.application.CustomApp
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class ApplicationModule(val app: CustomApp) {

    @Provides
    @Reusable
    fun providesContext() = app

}