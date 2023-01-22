package com.example.a20230124_timothyho_nycschools.di

import android.app.Application

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Component = DaggerComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
    companion object {
        lateinit var Component: Component
    }
}