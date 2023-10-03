package com.poklad.androidtestprojectny.di.viewModel

import androidx.lifecycle.ViewModel
import com.poklad.androidtestprojectny.presenatation.ui.screens.all_categories.AllCategoriesViewModel
import com.poklad.jobinterviewtestproject.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AllCategoriesViewModel::class)
    abstract fun bindAllCategoriesViewModel(allViewModel: AllCategoriesViewModel): ViewModel
}

