package com.pranay.aPODNasaKMP.domain.repositories

import com.pranay.aPODNasaKMP.domain.NetworkResultState
import com.pranay.aPODNasaKMP.domain.model.APODPictureItem
import com.pranay.aPODNasaKMP.source.remote.MediaRemoteDataSource

class NasaPicturesRepositoryImpl(
    private val mediaRemoteDataSource: MediaRemoteDataSource
) : NasaPicturesRepository {
    override suspend fun getAPODPictures(count: Int): NetworkResultState<List<APODPictureItem>?> {
        return mediaRemoteDataSource.getAPODNasaMediaList(count)
    }
}
