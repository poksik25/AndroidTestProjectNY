package com.poklad.androidtestprojectny.di.viewModel

import androidx.lifecycle.ViewModelProvider
import com.poklad.androidtestprojectny.di.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
