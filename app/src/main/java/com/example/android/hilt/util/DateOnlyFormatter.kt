package com.example.android.hilt.util

import android.annotation.SuppressLint
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@FragmentScoped
class DateOnlyFormatter @Inject constructor() : GeneralFormatter{

    @SuppressLint("SimpleDateFormat")
    private val formatter = SimpleDateFormat("d MMM yyyy")

    override fun formatDate(timestamp: Long): String {
        return formatter.format(Date(timestamp))
    }

}