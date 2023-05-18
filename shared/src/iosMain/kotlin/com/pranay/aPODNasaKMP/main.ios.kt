package com.pranay.aPODNasaKMP

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.pranay.aPODNasaKMP.di.koinInit
import com.pranay.aPODNasaKMP.krouter.LocalComponentContext
import platform.UIKit.UIViewController

actual fun getPlatformName(): String = "iOS"

fun MainViewController(): UIViewController {
    koinInit()
    return ComposeUIViewController {
        val lifecycle = LifecycleRegistry()
        val rootComponentContext = DefaultComponentContext(lifecycle = lifecycle)

        CompositionLocalProvider(LocalComponentContext provides rootComponentContext) {
            App()
        }
    }
}
