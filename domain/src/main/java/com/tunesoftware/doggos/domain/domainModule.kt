package com.tunesoftware.doggos.domain

import org.koin.dsl.module

val domainModule = module {

    single { GetBreedsUseCaseImpl(get()) }

    single { GetBreedDetailsUseCaseImpl(get()) }
}