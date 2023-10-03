package com.poklad.androidtestprojectny.di.component

import android.content.Context
import com.poklad.androidtestprojectny.di.annotations.ApplicationScope
import com.poklad.androidtestprojectny.di.module.DispatcherModule
import com.poklad.androidtestprojectny.di.module.NetworkModule
import com.poklad.androidtestprojectny.di.viewModel.ViewModelFactoryModule
import com.poklad.androidtestprojectny.di.viewModel.ViewModelModule
import com.poklad.androidtestprojectny.presenatation.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DispatcherModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
}