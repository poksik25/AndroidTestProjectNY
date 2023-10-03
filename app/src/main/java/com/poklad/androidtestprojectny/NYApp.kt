package com.poklad.androidtestprojectny

import android.app.Application
import com.poklad.androidtestprojectny.di.component.AppComponent
import com.poklad.androidtestprojectny.di.component.DaggerAppComponent

class NYApp : Application() {
    override fun onCreate() {
        super.onCreate()
        daggerAppComponent = DaggerAppComponent.factory().create(applicationContext)
    }

    companion object {
        lateinit var daggerAppComponent: AppComponent
    }
}