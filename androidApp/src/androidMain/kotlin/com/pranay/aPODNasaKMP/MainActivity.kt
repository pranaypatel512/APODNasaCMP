package com.pranay.aPODNasaKMP

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.view.WindowCompat
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.defaultComponentContext
import com.pranay.aPODNasaKMP.krouter.LocalComponentContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        val rootComponentContext: DefaultComponentContext = defaultComponentContext()

        setContent {
            CompositionLocalProvider(LocalComponentContext provides rootComponentContext) {
                MainView()
            }
        }
    }
}