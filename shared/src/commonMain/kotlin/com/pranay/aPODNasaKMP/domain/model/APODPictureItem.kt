package com.pranay.aPODNasaKMP.domain.model
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import kotlinx.serialization.Serializable

/**
 * API response item and database table for storing media items with details
 */
@Serializable
@Parcelize
data class APODPictureItem(
    var url: String,
    var copyright: String? = null,
    var date: String? = null,
    var explanation: String? = null,
    var hdurl: String? = null,
    var media_type: String? = null,
    var service_version: String? = null,
    var thumbnail_url: String? = null,
    var title: String? = null
) : Parcelable {
    fun isVideo(): Boolean = media_type == MediaType.video.toString()

    fun imageUrl(): String? = if (isVideo())thumbnail_url else url
}
