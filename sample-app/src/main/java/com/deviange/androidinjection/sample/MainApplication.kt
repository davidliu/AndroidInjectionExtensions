package com.deviange.androidinjection.sample

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.DaggerApplication

class MainApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerMainAppComponent.factory().create(this)
}

@Component(modules = [InjectorsModule::class])
interface MainAppComponent : AndroidInjector<MainApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: MainApplication): MainAppComponent
    }
}

@dagger.Module(includes = [AndroidInjectionModule::class])
interface InjectorsModule {
    @ContributesAndroidInjector(modules = [MainActivity.Module::class])
    fun mainActivity(): MainActivity
}