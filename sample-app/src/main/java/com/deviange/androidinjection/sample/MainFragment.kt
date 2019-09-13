package com.deviange.androidinjection.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deviange.androidinjection.AndroidInjectorContextWrapper
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerFragment

class MainFragment : DaggerFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onGetLayoutInflater(savedInstanceState: Bundle?): LayoutInflater {
        return super.onGetLayoutInflater(savedInstanceState)
            .cloneInContext(AndroidInjectorContextWrapper(androidInjector(), requireContext()))
    }

    @dagger.Module
    abstract class Module {
        @ContributesAndroidInjector
        abstract fun androidInjectedTextView(): AndroidInjectedTextView

        @dagger.Module
        companion object {
            @Provides
            @JvmStatic
            fun someString() = "Hi."
        }
    }


}