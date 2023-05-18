package com.pranay.aPODNasaKMP

import android.app.Application
import com.pranay.aPODNasaKMP.di.koinInit
import org.koin.android.ext.koin.androidContext

class APODNasaApp : Application() {

    override fun onCreate() {
        super.onCreate()
        koinInit {
            androidContext(applicationContext)
        }
    }
}
