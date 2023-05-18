package com.pranay.aPODNasaKMP.source.remote

import MyApplication.shared.BuildConfig
import com.pranay.aPODNasaKMP.domain.NetworkResultState
import com.pranay.aPODNasaKMP.domain.model.APODPictureItem
import com.pranay.aPODNasaKMP.util.Constants
import com.pranay.aPODNasaKMP.util.safeApiCallHandler
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MediaRemoteDataSourceImpl constructor(
    private val httpClient: HttpClient
) : MediaRemoteDataSource {
    override suspend fun getAPODNasaMediaList(count: Int): NetworkResultState<List<APODPictureItem>?> {
        return safeApiCallHandler {
            val response = httpClient.get(urlString = Constants.NASA_API_URL + "planetary/apod?api_key=" + BuildConfig.API_KEY) {
//            val response = httpClient.get(urlString = "planetary/apod") {
            /*val response = httpClient.get{
                url {
                    url("apod")
                    parameters.append("count", count.toString())
                }
            }*/
                parameter("count", count.toString())
            }.body<List<APODPictureItem>?>()
            response
        }
    }
}
