package com.pranay.aPODNasaKMP.domain.model

data class ErrorResponse(
    val code: Int,
    val msg: String,
    val service_version: String
):Exception()