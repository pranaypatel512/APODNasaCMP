package com.pranay.aPODNasaKMP.di

import com.pranay.aPODNasaKMP.domain.repositories.NasaPicturesRepository
import com.pranay.aPODNasaKMP.domain.repositories.NasaPicturesRepositoryImpl
import com.pranay.aPODNasaKMP.source.remote.MediaRemoteDataSourceImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<NasaPicturesRepository> { NasaPicturesRepositoryImpl(get<MediaRemoteDataSourceImpl>()) }
}

val dataSourceModule = module {
    single<MediaRemoteDataSourceImpl> { MediaRemoteDataSourceImpl(httpClient = get()) }
}
