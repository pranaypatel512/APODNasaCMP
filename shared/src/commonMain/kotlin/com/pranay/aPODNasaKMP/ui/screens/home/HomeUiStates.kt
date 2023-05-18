package com.pranay.aPODNasaKMP.ui.screens.home

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.pranay.aPODNasaKMP.domain.model.APODPictureItem

@Parcelize
data class HomeUiState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val apodPictureItemList: List<APODPictureItem>? = emptyList(),
) : Parcelable
