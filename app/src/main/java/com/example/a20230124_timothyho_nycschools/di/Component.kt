package com.example.a20230124_timothyho_nycschools.di

import com.example.a20230124_timothyho_nycschools.MainActivity
import com.example.a20230124_timothyho_nycschools.MainActivity2
import dagger.Component

@Component(
    modules =
    [
        ApplicationModule::class,
        NYCNetworkModule::class,
        NYCSchoolsRepositoryModule::class,
        ViewModelModule::class
    ]
)
interface Component {
    fun inject(mainActivity: MainActivity)
    fun inject2(mainActivity2: MainActivity2)
}