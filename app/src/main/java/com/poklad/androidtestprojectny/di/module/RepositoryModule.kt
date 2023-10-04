package com.poklad.androidtestprojectny.di.module

import com.poklad.androidtestprojectny.data.repositories.CategoryRepositoryImpl
import com.poklad.androidtestprojectny.domain.repositories.CategoryRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindGiphyRepository(repositoryImpl: CategoryRepositoryImpl): CategoryRepository
}