package com.pranay.aPODNasaKMP.util.insetsx

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import com.pranay.aPODNasaKMP.util.insetsx.ExperimentalSoftwareKeyboardApi

/**
 * Copied from library: https://github.com/mori-atsushi/insetsx
 */
expect val WindowInsets.Companion.navigationBars: WindowInsets
    @Composable get

expect val WindowInsets.Companion.statusBars: WindowInsets
    @Composable get

expect val WindowInsets.Companion.systemBars: WindowInsets
    @Composable get

@ExperimentalSoftwareKeyboardApi
expect val WindowInsets.Companion.ime: WindowInsets
    @Composable get

@ExperimentalSoftwareKeyboardApi
expect val WindowInsets.Companion.safeDrawing: WindowInsets
    @Composable get
