package com.pranay.aPODNasaKMP.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pranay.aPODNasaKMP.domain.model.APODPictureItem
import com.pranay.aPODNasaKMP.ui.componants.MediaItemComponent
import com.pranay.aPODNasaKMP.util.columnMinimumSize

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MediaItemList(
    modifier: Modifier = Modifier,
    mediaList: List<APODPictureItem> = emptyList(),
    onMedialSelected: (item: APODPictureItem) -> Unit,
) {
    var imageItemSelected by remember { mutableStateOf(-1) }
    var startLoadingAnimation by remember { mutableStateOf(false) }

    LazyVerticalStaggeredGrid(
        modifier = modifier.padding(top = 4.dp, bottom = 8.dp),
        columns = StaggeredGridCells.Adaptive(columnMinimumSize),
        contentPadding = PaddingValues(2.dp)
    ) {
        if (mediaList.isNotEmpty()) {
            itemsIndexed(mediaList) { index, photoItem ->
                key(index) {
                }
                MediaItemComponent(
                    modifier = Modifier.clickable {
                        onMedialSelected.invoke(photoItem)
                    },
                    mediaItem = photoItem,
                    backgroundImageUrl = photoItem.imageUrl() ?: "",
                    imageSelectedState = imageItemSelected == index
                )
            }
        }
    }
}
