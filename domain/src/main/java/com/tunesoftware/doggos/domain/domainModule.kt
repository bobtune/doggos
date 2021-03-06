package com.tunesoftware.doggos.domain

import org.koin.dsl.module

val domainModule = module {

    single<GetBreedsUseCase> { GetBreedsUseCaseImpl(get()) }

    single<GetBreedDetailsUseCase> { GetBreedDetailsUseCaseImpl(get()) }
}