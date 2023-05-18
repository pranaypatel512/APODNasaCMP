package com.pranay.aPODNasaKMP

import androidx.compose.runtime.Composable
import com.pranay.aPODNasaKMP.ui.RootComponent
import com.pranay.aPODNasaKMP.ui.theme.APODNasaKMPTheme

@Composable
fun App() {
    APODNasaKMPTheme(darkTheme = true) {
        RootComponent()
    }
}

expect fun getPlatformName(): String
