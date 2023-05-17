package com.pranay.aPODNasaKMP.di

import com.pranay.aPODNasaKMP.domain.repositories.NasaPicturesRepository
import com.pranay.aPODNasaKMP.domain.repositories.NasaPicturesRepositoryImpl
import com.pranay.aPODNasaKMP.source.remote.PhotoDataSourceImpl
import io.ktor.client.HttpClient
import org.koin.dsl.module

val repositoryModule = module {

    single<NasaPicturesRepository> { NasaPicturesRepositoryImpl(get<PhotoDataSourceImpl>()) }
}

val dataSourceModule = module {
    single { PhotoDataSourceImpl(get<HttpClient>()) }
}