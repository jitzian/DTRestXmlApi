package com.example.digital.turbine.assigment.base.fragments

import android.view.View
import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment : DialogFragment() {
    protected lateinit var rootView: View
    protected lateinit var TAG: String

    abstract fun initView()
}