package com.deviange.androidinjection

import android.content.Context
import android.content.ContextWrapper
import android.view.View
import dagger.android.HasAndroidInjector

object AndroidInjectionExt {
    private fun inject(target: Any, context: Context) {
        findNearestAndroidInjector(target, context).androidInjector().inject(target)
    }

    fun inject(view: View) {
        inject(view, view.context)
    }

    private fun findNearestAndroidInjector(target: Any, context: Context): HasAndroidInjector {
        var parentContext = context
        while (true) {
            if (parentContext is HasAndroidInjector) {
                return parentContext
            }

            if (parentContext == context.applicationContext) {
                break
            }

            parentContext = if (parentContext is ContextWrapper) {
                parentContext.baseContext
            } else context.applicationContext
        }

        throw IllegalArgumentException("No injector was found for ${target::class.qualifiedName}")
    }
}