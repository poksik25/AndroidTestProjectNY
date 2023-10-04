package com.poklad.androidtestprojectny.di.module

import com.poklad.androidtestprojectny.data.repositories.BookRepositoryImpl
import com.poklad.androidtestprojectny.data.repositories.CategoryRepositoryImpl
import com.poklad.androidtestprojectny.domain.repositories.BooksRepository
import com.poklad.androidtestprojectny.domain.repositories.CategoryRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindCategoryRepository(repositoryImpl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    abstract fun bindBooksRepository(repositoryImpl: BookRepositoryImpl): BooksRepository
}