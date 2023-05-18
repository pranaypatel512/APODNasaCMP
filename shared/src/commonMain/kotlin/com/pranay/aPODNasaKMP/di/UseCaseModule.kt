package com.pranay.aPODNasaKMP.di

import com.pranay.aPODNasaKMP.domain.usecase.GetAPODNasaMediaListUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single { GetAPODNasaMediaListUseCase(get()) }
}
