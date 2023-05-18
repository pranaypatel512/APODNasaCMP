package com.pranay.aPODNasaKMP.domain.usecase

import com.pranay.aPODNasaKMP.domain.NetworkResultState
import com.pranay.aPODNasaKMP.domain.isLoading
import com.pranay.aPODNasaKMP.domain.model.APODPictureItem
import com.pranay.aPODNasaKMP.domain.onFailure
import com.pranay.aPODNasaKMP.domain.onSuccess
import com.pranay.aPODNasaKMP.domain.repositories.NasaPicturesRepository
import com.pranay.aPODNasaKMP.ui.screens.home.HomeUiStates

class GetAPODNasaMediaListUseCase(
    private val repository: NasaPicturesRepository
) : UseCase<NetworkResultState<List<APODPictureItem>>, Int> {
    suspend operator fun invoke(count: Int) =
        repository.getAPODPictures(count).isLoading { isLoading ->
            HomeUiStates(isLoading = isLoading)
        }.onSuccess { apodPictureItemList ->
            HomeUiStates(apodPictureItemList = apodPictureItemList)
        }.onFailure { error ->
            HomeUiStates(error = error.message)
        }
}
