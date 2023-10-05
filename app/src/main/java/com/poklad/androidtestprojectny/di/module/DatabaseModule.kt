package com.poklad.androidtestprojectny.di.module

import android.content.Context
import androidx.room.Room
import com.poklad.androidtestprojectny.data.local.database.NYBooksDatabase
import com.poklad.androidtestprojectny.di.annotations.ApplicationScope
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
            "ny_books.db"
        ).build()
    }
}