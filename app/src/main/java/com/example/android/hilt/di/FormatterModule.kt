package com.example.android.hilt.di

import com.example.android.hilt.util.DateAndTimeFormatter
import com.example.android.hilt.util.DateAndTimeFormatter_Factory
import com.example.android.hilt.util.DateOnlyFormatter
import com.example.android.hilt.util.GeneralFormatter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION)
@MustBeDocumented
annotation class QualifierDateOnlyFormatter

@Qualifier
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION)
@MustBeDocumented
annotation class QualifierDateAndTimeFormatter

@Module
@InstallIn(FragmentComponent::class)
abstract class FormatterModule {

    @QualifierDateOnlyFormatter
    @FragmentScoped
    @Binds
    abstract fun bindDateOnlyFormatter(impl: DateOnlyFormatter):
            GeneralFormatter

    @QualifierDateAndTimeFormatter
    @FragmentScoped
    @Binds
    abstract fun bindDateAndTimeFormatter(impl: DateAndTimeFormatter):
            GeneralFormatter

}