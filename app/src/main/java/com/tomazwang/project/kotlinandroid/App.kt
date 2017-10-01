package com.tomazwang.project.kotlinandroid

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by TomazWang on 25/09/2017.
 */
class App : Application(){

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        if(BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }


    }

}