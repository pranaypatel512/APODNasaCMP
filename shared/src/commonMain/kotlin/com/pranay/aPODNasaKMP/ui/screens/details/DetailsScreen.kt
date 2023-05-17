package com.pranay.aPODNasaKMP.ui.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pranay.aPODNasaKMP.ui.theme.md_theme_light_primary


@Composable
fun DetailsScreen(onNavigationBack : () -> Unit ) {
    Box(modifier = Modifier.fillMaxHeight().fillMaxWidth(), contentAlignment = Alignment.Center){
        Text("DetailsScreen", color = md_theme_light_primary, modifier = Modifier.clickable {
            onNavigationBack.invoke()
        })
    }
}