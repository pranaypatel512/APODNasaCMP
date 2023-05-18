package com.pranay.aPODNasaKMP.source.remote

import com.pranay.aPODNasaKMP.domain.NetworkResultState
import com.pranay.aPODNasaKMP.domain.model.APODPictureItem

interface PhotoDataSource {

    suspend fun getAPODNasaMediaList(count: Int): NetworkResultState<List<APODPictureItem>?>
}
