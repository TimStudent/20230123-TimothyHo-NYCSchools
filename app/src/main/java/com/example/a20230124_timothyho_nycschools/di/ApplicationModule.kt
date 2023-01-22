package com.example.a20230124_timothyho_nycschools.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.migration.DisableInstallInCheck

@DisableInstallInCheck
@Module
class ApplicationModule(private val application: Application) {

    @Provides
    fun providesContext(): Context = application.applicationContext
}