package com.example.digital.turbine.assigment.application

import android.app.Application
import com.example.digital.turbine.assigment.dagger.components.DaggerApplicationComponentInjector
import com.example.digital.turbine.assigment.dagger.modules.ApplicationModule

class CustomApp : Application() {

    private val injector = DaggerApplicationComponentInjector.builder()
        .applicationModule(ApplicationModule(this))
        .build()

    override fun onCreate() {
        super.onCreate()
        instance = this
        inject()
    }

    private fun inject() {
        injector.inject(this)
    }

    companion object {
        lateinit var instance: CustomApp private set
    }

}