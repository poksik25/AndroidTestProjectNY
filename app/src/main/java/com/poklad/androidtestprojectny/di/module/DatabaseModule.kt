package com.poklad.androidtestprojectny.di.module

import android.content.Context
import androidx.room.Room
import com.poklad.androidtestprojectny.data.local.database.NYBooksDatabase
import com.poklad.androidtestprojectny.di.annotations.ApplicationScope
import com.poklad.androidtestprojectny.utils.DatabaseConstants
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @Provides
    @ApplicationScope
    fun provideNYBooksDatabase(context: Context): NYBooksDatabase {
        return Room.databaseBuilder(
            context = context,
            NYBooksDatabase::class.java,
            DatabaseConstants.DATABASE_NAME
        ).build()
    }

    @ApplicationScope
    @Provides
    fun providesCategoryDao(database: NYBooksDatabase) = database.getCategoryDao()
}