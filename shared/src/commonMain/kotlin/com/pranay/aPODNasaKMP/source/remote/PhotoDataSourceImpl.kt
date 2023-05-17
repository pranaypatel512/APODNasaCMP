package com.pranay.aPODNasaKMP.source.remote

import com.pranay.aPODNasaKMP.domain.NetworkResultState
import com.pranay.aPODNasaKMP.domain.model.APODPictureItem
import com.pranay.aPODNasaKMP.util.safeApiCallHandler
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PhotoDataSourceImpl(
    private val httpClient: HttpClient
) : PhotoDataSource {
    override suspend fun getAPODNasaMediaList(count: Int): NetworkResultState<List<APODPictureItem>?> {
        return safeApiCallHandler {
                val response = httpClient.get(urlString = "apod") {
                    parameter("count", count)
                    Napier.i("URL->$url")
                }.body<List<APODPictureItem>?>()
                response
            }

    }

}