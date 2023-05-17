package com.pranay.aPODNasaKMP.domain.repositories

import com.pranay.aPODNasaKMP.domain.NetworkResultState
import com.pranay.aPODNasaKMP.domain.model.APODPictureItem
import kotlinx.coroutines.flow.Flow

interface NasaPicturesRepository {
    suspend fun getAPODPictures(
        count: Int = 10
    ): NetworkResultState<List<APODPictureItem>?>
}