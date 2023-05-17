package com.pranay.aPODNasaKMP.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun koinInit(appDeclaration: KoinAppDeclaration={}){
    startKoin {
        appDeclaration()
        modules(networkModule, useCaseModule, repositoryModule, dataSourceModule)
    }
}