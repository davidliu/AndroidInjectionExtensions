package com.deviange.androidinjection.sample

import android.os.Bundle
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    @dagger.Module
    abstract class Module {
        @ContributesAndroidInjector(modules = [MainFragment.Module::class])
        abstract fun mainFragment(): MainFragment
    }

}
