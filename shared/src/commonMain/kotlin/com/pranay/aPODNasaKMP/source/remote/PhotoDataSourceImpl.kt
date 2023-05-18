package com.pranay.aPODNasaKMP.source.remote

import MyApplication.shared.BuildConfig
import com.pranay.aPODNasaKMP.domain.NetworkResultState
import com.pranay.aPODNasaKMP.domain.model.APODPictureItem
import com.pranay.aPODNasaKMP.util.Constants
import com.pranay.aPODNasaKMP.util.safeApiCallHandler
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class PhotoDataSourceImpl constructor(
    private val httpClient: HttpClient
) : PhotoDataSource {
    override suspend fun getAPODNasaMediaList(count: Int): NetworkResultState<List<APODPictureItem>?> {
        return safeApiCallHandler {
            val response = httpClient.get(urlString = Constants.NASA_API_URL + "apod?api_key=" + BuildConfig.API_KEY) {
                parameter("count", count)
                Napier.i("URL->$url")
            }.body<List<APODPictureItem>?>()
            response
        }
    }
}
