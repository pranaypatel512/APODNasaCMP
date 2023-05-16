package com.pranay.aPODNasaKMP.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.pranay.aPODNasaKMP.krouter.RoutedContent
import com.pranay.aPODNasaKMP.krouter.rememberRouter
import com.pranay.aPODNasaKMP.ui.screens.details.DetailsScreen
import com.pranay.aPODNasaKMP.ui.screens.home.HomeScreen
import com.pranay.aPODNasaKMP.ui.theme.APODNasaKMPTheme

@Composable
fun RootComponent(
) {
    val router = rememberRouter(RootStateModel::class, listOf(RootStateModel.HomeScreen))
    APODNasaKMPTheme(darkTheme = true) {
        RoutedContent(
            router = router,
            animation = stackAnimation(animator = slide()),
            content = { screen ->
                when (screen) {
                    is RootStateModel.HomeScreen -> HomeScreen {
                        router.push(RootStateModel.DetailsScreen)
                    }
                    is RootStateModel.DetailsScreen -> DetailsScreen {
                        router.pop()
                    }
                }
            }
        )
    }
}

@Parcelize
sealed class RootStateModel : Parcelable {
    object HomeScreen : RootStateModel()
    object DetailsScreen : RootStateModel()
}
