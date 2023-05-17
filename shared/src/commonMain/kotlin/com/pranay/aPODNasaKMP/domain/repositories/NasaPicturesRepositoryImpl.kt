package com.pranay.aPODNasaKMP.domain.repositories

import com.pranay.aPODNasaKMP.domain.NetworkResultState
import com.pranay.aPODNasaKMP.domain.model.APODPictureItem
import com.pranay.aPODNasaKMP.source.remote.PhotoDataSource
import kotlinx.coroutines.flow.Flow

class NasaPicturesRepositoryImpl(
    private val photoDataSource: PhotoDataSource
) : NasaPicturesRepository {
    override suspend fun getAPODPictures(count: Int): NetworkResultState<List<APODPictureItem>?> {
        return photoDataSource.getAPODNasaMediaList(count)
    }

}
