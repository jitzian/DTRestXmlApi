package com.example.digital.turbine.assigment.base.viewmodels

import androidx.lifecycle.ViewModel
import com.example.digital.turbine.assigment.rest.RestApi
import java.util.logging.Logger
import kotlin.properties.Delegates

abstract class BaseViewModel : ViewModel() {
    protected var TAG: String by Delegates.notNull()
    protected var logger: Logger by Delegates.notNull()
    protected var restApi: RestApi by Delegates.notNull()
}