package com.pranay.aPODNasaKMP

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.pranay.aPODNasaKMP.krouter.LocalComponentContext

actual fun getPlatformName(): String = "Desktop"

@Composable
fun MainView() {
    val lifecycle = LifecycleRegistry()
    val rootComponentContext = DefaultComponentContext(lifecycle = lifecycle)
    CompositionLocalProvider(LocalComponentContext provides rootComponentContext) {
        App()
    }
}
