package com.deviange.androidinjection

import android.content.Context
import android.content.ContextWrapper
import dagger.android.AndroidInjector
import dagger.android.HasAndroidInjector

class AndroidInjectorContextWrapper(
    private val androidInjector: AndroidInjector<Any>,
    base: Context
) :
    ContextWrapper(base), HasAndroidInjector {
    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}