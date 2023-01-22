package com.example.a20230124_timothyho_nycschools.di

import com.example.a20230124_timothyho_nycschools.api.NYCAPI
import com.example.a20230124_timothyho_nycschools.repository.NYCSchoolsRepository
import com.example.a20230124_timothyho_nycschools.repository.NYCSchoolsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class NYCSchoolsRepositoryModule {
    @Binds
    abstract fun schoolsRepository(
        impl: NYCSchoolsRepositoryImpl
    ): NYCSchoolsRepository
}