package com.deviange.androidinjection

import android.os.Bundle
import android.view.LayoutInflater
import dagger.android.support.DaggerFragment

open class DaggerFragmentExt : DaggerFragment() {
    override fun onGetLayoutInflater(savedInstanceState: Bundle?): LayoutInflater {
        return super.onGetLayoutInflater(savedInstanceState)
            .cloneInContext(AndroidInjectorContextWrapper(androidInjector(), requireContext()))
    }
}