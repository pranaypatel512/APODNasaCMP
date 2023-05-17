package com.pranay.aPODNasaKMP.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pranay.aPODNasaKMP.domain.NetworkResultState
import com.pranay.aPODNasaKMP.krouter.rememberViewModel
import com.pranay.aPODNasaKMP.ui.theme.Blue70
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeScreen(onSelectItem : (String) -> Unit ) {
    val viewModel: HomeScreenViewModel =
        rememberViewModel(HomeScreenViewModel::class) { savedState -> HomeScreenViewModel(savedState) }

    // collectAsStateWithLifecycle() is an Android specific extension
    // hence not available here
    val state = viewModel.state.collectAsState()
    Box(modifier = Modifier.fillMaxHeight().fillMaxWidth(), contentAlignment = Alignment.Center){
        if(state.value.isLoading){
            CircularProgressIndicator()
        }else if (!state.value.error.isNullOrEmpty()){
            Text(state.value.error?:"", color = Blue70, modifier = Modifier.clickable {
                onSelectItem.invoke("Test")
            })
        }else{
            Text(state.value.apodPictureItemList?.size.toString(), color = Blue70, modifier = Modifier.clickable {
                onSelectItem.invoke("Test")
            })
        }
    }
}
