package com.pranay.aPODNasaKMP.domain.repositories

import com.pranay.aPODNasaKMP.domain.NetworkResultState
import com.pranay.aPODNasaKMP.domain.model.APODPictureItem

interface NasaPicturesRepository {
    suspend fun getAPODPictures(
        count: Int = 10
    ): NetworkResultState<List<APODPictureItem>?>
}
