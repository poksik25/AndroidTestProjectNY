package com.poklad.androidtestprojectny.di.component

import android.content.Context
import com.poklad.androidtestprojectny.di.annotations.ApplicationScope
import com.poklad.androidtestprojectny.di.module.DatabaseModule
import com.poklad.androidtestprojectny.di.module.DispatcherModule
import com.poklad.androidtestprojectny.di.module.NetworkModule
import com.poklad.androidtestprojectny.di.module.RepositoryModule
import com.poklad.androidtestprojectny.di.viewModel.ViewModelFactoryModule
import com.poklad.androidtestprojectny.di.viewModel.ViewModelModule
import com.poklad.androidtestprojectny.presenatation.MainActivity
import com.poklad.androidtestprojectny.presenatation.ui.screens.all_categories.AllCategoriesFragment
import com.poklad.androidtestprojectny.presenatation.ui.screens.books_list.BooksByCategoryFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DispatcherModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: AllCategoriesFragment)
    fun inject(fragment: BooksByCategoryFragment)
}