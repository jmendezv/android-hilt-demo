package com.example.android.hilt.di

import com.example.android.hilt.navigator.AppNavigator
import com.example.android.hilt.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationModule {

    /*
    * @Binds methods must have exactly one parameter, whose type is assignable to the return type
    *
    * */
    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator

}