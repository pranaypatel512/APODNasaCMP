package com.pranay.aPODNasaKMP

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.core.view.WindowCompat
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.defaultComponentContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pranay.aPODNasaKMP.krouter.LocalComponentContext
import com.pranay.aPODNasaKMP.ui.theme.md_theme_dark_background

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val rootComponentContext: DefaultComponentContext = defaultComponentContext()

        setContent {
            CompositionLocalProvider(LocalComponentContext provides rootComponentContext) {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = md_theme_dark_background,
                        darkIcons = false
                    )
                }
                MainView()
            }
        }
    }
}
