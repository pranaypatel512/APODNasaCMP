package com.pranay.aPODNasaKMP.source.remote

import com.pranay.aPODNasaKMP.domain.NetworkResultState
import com.pranay.aPODNasaKMP.domain.model.APODPictureItem
import kotlinx.coroutines.flow.Flow

interface PhotoDataSource {

    suspend fun getAPODNasaMediaList(count: Int): NetworkResultState<List<APODPictureItem>?>

}