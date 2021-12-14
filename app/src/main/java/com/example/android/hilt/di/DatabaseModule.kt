package com.example.android.hilt.di

import android.content.Context
import android.content.res.AssetManager
import androidx.room.Room
import com.example.android.hilt.data.AppDatabase
import com.example.android.hilt.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
* Hilt Modules cannot contain both non-static and abstract binding methods, so you cannot place
* @Binds and @Provides annotations in the same class.
*
* */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideLogDao(database: AppDatabase): LogDao = database.logDao()

    /*
    * Singleton because we always want Hilt to provide the same database instance
    * */
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "loggin.db").build()

    @Provides
    @Singleton
    fun provideAssetManager(@ApplicationContext context: Context): AssetManager =
        context.assets

}