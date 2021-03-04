package com.tunesoftware.doggos.data

import com.tunesoftware.doggos.domain.DogRepository
import org.koin.dsl.module

val dataModule = module {

    single { createGson() }

    single { createGsonConverter(get()) }

    single { createOkHttpClient() }

    single<DogApi> { createRetrofit(get(), get(), BuildConfig.API_URL) }

    single<DogRepository> { DogRepositoryImpl(get()) }
}