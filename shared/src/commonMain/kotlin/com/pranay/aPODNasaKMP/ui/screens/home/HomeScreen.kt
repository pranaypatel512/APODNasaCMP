package com.pranay.aPODNasaKMP.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pranay.aPODNasaKMP.krouter.rememberViewModel
import com.pranay.aPODNasaKMP.util.insetsx.safeDrawing
import org.jetbrains.compose.resources.ExperimentalResourceApi
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pranay.aPODNasaKMP.ui.theme.md_theme_light_primary
import com.pranay.aPODNasaKMP.util.insetsx.ExperimentalSoftwareKeyboardApi

@OptIn(ExperimentalResourceApi::class, ExperimentalSoftwareKeyboardApi::class)
@Composable
fun HomeScreen(onSelectItem : (String) -> Unit ) {
    val viewModel: HomeScreenViewModel =
        rememberViewModel(HomeScreenViewModel::class) { savedState -> HomeScreenViewModel(savedState) }

    // collectAsStateWithLifecycle() is an Android specific extension
    // hence not available here
    val state = viewModel.state.collectAsState()
    Scaffold(modifier = Modifier.windowInsetsPadding(
        WindowInsets.safeDrawing.only(WindowInsetsSides.Vertical)
    ), topBar = {
        TopAppBar {
          Text("APODNasa", color = Color.White.copy(alpha = 0.8f), style = TextStyle.Default.copy(fontSize = 20.sp), modifier = Modifier.padding(horizontal = 12.dp))
        }
    }
    ){
        Box(modifier = Modifier.fillMaxHeight().fillMaxWidth(), contentAlignment = Alignment.Center){
            if(state.value.isLoading){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }else if (!state.value.error.isNullOrEmpty()){
                Text(state.value.error?:"", color = md_theme_light_primary, modifier = Modifier.clickable {
                    onSelectItem.invoke("Test")
                })
            }else{
                MediaItemList(mediaList = state.value.apodPictureItemList ?: listOf(), modifier = Modifier.align(Alignment.TopCenter)) {
                }
            }
        }
    }
}
