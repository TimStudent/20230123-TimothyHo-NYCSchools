package com.example.a20230124_timothyho_nycschools.di

import com.example.a20230124_timothyho_nycschools.NycCCModelFactory
import com.example.a20230124_timothyho_nycschools.repository.NYCSchoolsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.migration.DisableInstallInCheck

@InstallIn(ViewModelComponent::class)
@Module
class ViewModelModule {
    @Provides
    fun providesModelModelFactory(
        repository: NYCSchoolsRepository
    ): NycCCModelFactory =
        NycCCModelFactory(repository)
}