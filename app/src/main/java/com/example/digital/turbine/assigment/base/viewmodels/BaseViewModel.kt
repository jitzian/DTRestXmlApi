package com.example.digital.turbine.assigment.base.viewmodels

import androidx.lifecycle.ViewModel
import java.util.logging.Logger

abstract class BaseViewModel : ViewModel() {
    protected lateinit var TAG: String
    protected lateinit var logger: Logger
}