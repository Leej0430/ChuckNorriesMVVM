package com.example.chucknorriesmvvm

import android.app.Application
import android.content.Context

class NorrisApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        norrisContext = applicationContext
    }
    companion object{
        lateinit var norrisContext:Context
    }

}