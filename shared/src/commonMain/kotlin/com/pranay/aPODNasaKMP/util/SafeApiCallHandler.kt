package com.pranay.aPODNasaKMP.util

import com.pranay.aPODNasaKMP.domain.NetworkResultState
import com.pranay.aPODNasaKMP.domain.model.ErrorResponse
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException

suspend fun <T : Any?> safeApiCallHandler(apiCall: suspend () -> T): NetworkResultState<T> {
    return try {
        NetworkResultState.Loading

        NetworkResultState.Success(apiCall.invoke())
    } catch (e: ClientRequestException) {
        val error = parseNetworkError(e.response.body())
        NetworkResultState.Failure(exception = error)
    } catch (e: RedirectResponseException) {
        val error = parseNetworkError(e.response.body())
        NetworkResultState.Failure(exception = error)
    } catch (e: ServerResponseException) {
        val error = parseNetworkError(e.response.body())
        NetworkResultState.Failure(exception = error)
    } catch (e: UnresolvedAddressException) {
        val error = parseNetworkError(exception = e)
        NetworkResultState.Failure(exception = error)
    } catch (e: NoTransformationFoundException) {
        NetworkResultState.Failure(e)
    } catch (e: Exception) {
        val error = parseNetworkError(exception = e)
        NetworkResultState.Failure(exception = error)
    }
}

suspend fun parseNetworkError(
    errorResponse: HttpResponse? = null,
    exception: Exception? = null
): Exception {
    throw errorResponse?.body<ErrorResponse>() ?: ErrorResponse(
        code = 0,
        service_version="v1",
        msg = exception?.message ?: "Error"
    )
}